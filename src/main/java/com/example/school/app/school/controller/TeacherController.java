package com.example.school.app.school.controller;

import com.example.school.app.school.dto.TeacherRequest;
import com.example.school.app.school.dto.TeacherResponse;
import com.example.school.app.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public List<TeacherResponse> radAll(@RequestParam(name = "id",
            required = false) String id){

        if(id == null){

            return teacherService.read();
        }else
            return Collections.singletonList(teacherService.read(id));

    }
    @DeleteMapping
    public void deleteTeacher(@RequestParam(name = "id",
            required = true) String id){

        teacherService.delete(id);
    }

    @PutMapping
    public void updateTeacher(@RequestBody TeacherRequest teacherRequest){
        teacherService.update(teacherRequest);

    }



}
