package com.example.school.app.school.service.impl;

import com.example.school.app.school.common.service.impl.BaseServiceImpl;
import com.example.school.app.school.dto.StudentRequest;
import com.example.school.app.school.dto.StudentResponse;
import com.example.school.app.school.model.Student;
import com.example.school.app.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentRequest,
        Student, StudentResponse, String> {


    public StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponse> modelToResponse(List<Student> sList) {
        return sList.stream().map(this::modelToResponse
        ).collect(Collectors.toList());
    }

    @Override
    public JpaRepository<Student, String> getRepository() {
        return studentRepository;
    }

    public Student requestToModel(StudentRequest request) {

        Student student = new Student();
        student.setId(request.getId());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setDob(LocalDate.now().toString());
        return student;
    }

    public StudentResponse modelToResponse(Student student) {

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setEmail(student.getEmail());
        response.setDob(student.getDob());
        return response;

    }

}