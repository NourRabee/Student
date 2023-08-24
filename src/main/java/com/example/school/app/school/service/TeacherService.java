package com.example.school.app.school.service;

import com.example.school.app.school.dto.TeacherRequest;
import com.example.school.app.school.dto.TeacherResponse;
import com.example.school.app.school.model.Teacher;
import com.example.school.app.school.repository.TeacherRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponse create(TeacherRequest teacherRequest) {

        Teacher teacher = requestToModel(teacherRequest);
        return modelToResponse(teacherRepository.save(teacher));

    }

    private TeacherResponse modelToResponse(Teacher teacher) {

        TeacherResponse response = new TeacherResponse(teacher.getId(),
                teacher.getEmail(), teacher.getCourse(), teacher.getAge());

        return response;
    }
    private List<TeacherResponse> modelToResponse(List<Teacher>teachers) {

        return teachers.stream().map(this::modelToResponse
        ).collect(Collectors.toList());

    }

    private Teacher requestToModel(TeacherRequest teacherRequest) {

        Teacher teacher;
        LocalDate currentDate = LocalDate.now();
        LocalDate dob = teacherRequest.getDob();
        Period age = Period.between(dob, currentDate);
        int years = age.getYears();

        teacher = new Teacher(teacherRequest.getId(), teacherRequest.getDob()
                , teacherRequest.getEmail(), years, teacherRequest.getCourse());
        return teacher;

    }

    public List<TeacherResponse> read() {

       return modelToResponse(teacherRepository.findAll());
    }

    public void delete(TeacherRequest teacherRequest) {

        teacherRepository.deleteById(teacherRequest.getId());
    }

    public void update(TeacherRequest teacherRequest) {

        if(teacherRepository.existsById(teacherRequest.getId())){

           // Teacher oldTeacher = teacherRepository.findById(teacherRequest.getId()).get();
            Teacher newTeacher = requestToModel(teacherRequest);
            teacherRepository.save(newTeacher);

        }
    }
}
