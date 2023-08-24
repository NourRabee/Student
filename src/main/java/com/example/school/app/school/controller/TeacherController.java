package com.example.school.app.school.controller;

import com.example.school.app.school.dto.TeacherRequest;
import com.example.school.app.school.dto.TeacherResponse;
import com.example.school.app.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {


    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public TeacherResponse createTeacher(@RequestBody TeacherRequest teacherRequest){

        return teacherService.create(teacherRequest);

    }
    @GetMapping
    public List<TeacherResponse> radAll(){

        return teacherService.read();

    }
    @DeleteMapping
    public void deleteTeacher(@RequestBody TeacherRequest teacherRequest){

        teacherService.delete(teacherRequest);
    }

    @PutMapping
    public void updateTeacher(@RequestBody TeacherRequest teacherRequest){
        teacherService.update(teacherRequest);

    }



}
