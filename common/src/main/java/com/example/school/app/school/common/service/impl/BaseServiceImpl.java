package com.example.school.app.school.common.service.impl;

import com.example.school.app.school.common.dto.BaseRequest;
import com.example.school.app.school.common.dto.BaseResponse;
import com.example.school.app.school.common.model.BaseModel;
import com.example.school.app.school.common.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseServiceImpl<RQ extends BaseRequest<K>,
        M extends BaseModel<K>, RS extends BaseResponse, K> implements BaseService<RQ, M, RS, K> {

    public abstract JpaRepository<M, K> getRepository();

    public abstract M requestToModel(RQ rq);

    public abstract RS modelToResponse(M m);

    public abstract List<RS> modelToResponse(List<M> List);

    @Override
    public List<RS> read() {

        List<M> m = getRepository().findAll();
        return modelToResponse(m);
    }

    @Override
    public RS create(RQ rq) {

        M m = requestToModel(rq);
        return modelToResponse(getRepository().save(m));
    }

    @Override
    public void delete(K k) {

        getRepository().deleteById(k);
    }

    @Override
    public RS read(K k) {

        return modelToResponse(getRepository().findById(k).get());

    }

    @Override
    public void update(RQ rq) {

        if (getRepository().findById(rq.getId()).isPresent()) {

            M newStudent = requestToModel(rq);
            getRepository().save(newStudent);
        }
    }


}
