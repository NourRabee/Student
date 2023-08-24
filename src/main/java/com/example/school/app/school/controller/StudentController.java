package com.example.school.app.school.controller;

import com.example.school.app.school.dto.StudentRequest;
import com.example.school.app.school.dto.StudentResponse;
import com.example.school.app.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private final StudentService studentService = new StudentService();


    @PostMapping
    public StudentResponse addNewStudent(@RequestBody StudentRequest studentRequest) {

        return studentService.create(studentRequest);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.delete(studentId);
    }

    @GetMapping
    public List<StudentResponse> getStudent(@RequestParam(name = "id",
            required =
            false) String id) {
        if (id == null) {

            return studentService.read();
        }
        return Collections.singletonList(studentService.read(id));
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentRequest studentRequest){

        studentService.update(studentRequest);
    }

}
