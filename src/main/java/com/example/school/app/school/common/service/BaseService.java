package com.example.school.app.school.common.service;


import com.example.school.app.school.common.dto.BaseRequest;
import com.example.school.app.school.common.dto.BaseResponse;
import com.example.school.app.school.common.model.BaseModel;

import java.util.List;

public interface BaseService<RQ extends BaseRequest<K>, M extends BaseModel<K>,
        RS extends BaseResponse, K>{

    public List<RS> read();

    public RS create(RQ rq);

    public void delete(K k);

    public RS read(K k);

    public void update(RQ rq);

}
