package com.example.school.app.school.controller;

import com.example.school.app.school.dto.StudentRequest;
import com.example.school.app.school.dto.StudentResponse;
import com.example.school.app.school.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;
    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }


    @PostMapping
    public StudentResponse addNewStudent(@RequestBody StudentRequest studentRequest) {

        return studentServiceImpl.create(studentRequest);
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam(name = "id",
            required = true) String id) {
        studentServiceImpl.delete(id);
    }

    @GetMapping
    public List<StudentResponse> getStudent(@RequestParam(name = "id",
            required =
            false) String id) {
        if (id == null) {

            return studentServiceImpl.read();
        }
        return Collections.singletonList(studentServiceImpl.read(id));
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentRequest studentRequest){

        studentServiceImpl.update(studentRequest);
    }

}

