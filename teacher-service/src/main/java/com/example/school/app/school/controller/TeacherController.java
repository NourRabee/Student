package com.example.school.app.school.controller;

import com.example.school.app.school.dto.TeacherRequest;
import com.example.school.app.school.dto.TeacherResponse;
import com.example.school.app.school.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {


    private final TeacherServiceImpl teacherServiceImpl;

    @Autowired
    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @PostMapping
    public TeacherResponse createTeacher(@RequestBody TeacherRequest teacherRequest){

        return teacherServiceImpl.create(teacherRequest);

    }
    @GetMapping
    public List<TeacherResponse> radAll(@RequestParam(name = "id",
            required = false) String id){

        if(id == null){

            return teacherServiceImpl.read();
        }else
            return Collections.singletonList(teacherServiceImpl.read(id));

    }
    @DeleteMapping
    public void deleteTeacher(@RequestParam(name = "id",
            required = true) String id){

        teacherServiceImpl.delete(id);
    }

    @PutMapping
    public void updateTeacher(@RequestBody TeacherRequest teacherRequest){
        teacherServiceImpl.update(teacherRequest);

    }



}
