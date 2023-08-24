package com.example.demo.student.service;

import com.example.demo.student.dto.StudentRequest;
import com.example.demo.student.dto.StudentResponse;
import com.example.demo.student.model.Student;
import com.example.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<StudentResponse> read() {

        List<Student> students = studentRepository.findAll();
        return modelToResponse(students);
    }

    private List<StudentResponse> modelToResponse(List<Student> sList) {
        return sList.stream().map(this::modelToResponse
        ).collect(Collectors.toList());
    }

    public StudentResponse create(StudentRequest request) {

        Student student = requestToModel(request);
        return modelToResponse(studentRepository.save(student));
    }

    public Student requestToModel(StudentRequest request) {

        Student student = new Student();
        student.setId(request.getId());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setDob(LocalDate.now());
        return student;
    }

    public StudentResponse modelToResponse(Student student) {

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setEmail(student.getEmail());
        response.setDob(student.getDob());
        return response;

    }

    public void delete(String id) {

        studentRepository.deleteById(id);
    }

    public StudentResponse read(String id) {

        return modelToResponse(studentRepository.findById(id).get());

    }

    public void update(StudentRequest studentRequest) {

        if (studentRepository.findById(studentRequest.getId()).isPresent()) {

            Student newStudent = requestToModel(studentRequest);
            studentRepository.save(newStudent);
        }
    }
}