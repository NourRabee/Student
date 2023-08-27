package com.example.school.app.school.service;

import com.example.school.app.school.dto.TeacherRequest;
import com.example.school.app.school.dto.TeacherResponse;
import com.example.school.app.school.model.Student;
import com.example.school.app.school.model.Teacher;
import com.example.school.app.school.repository.TeacherRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentService studentService;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, StudentService studentService) {
        this.teacherRepository = teacherRepository;
        this.studentService = studentService;
    }

    public TeacherResponse create(TeacherRequest teacherRequest) {

        Teacher teacher = requestToModel(teacherRequest);
        return modelToResponse(teacherRepository.save(teacher));

    }

    private TeacherResponse modelToResponse(Teacher teacher) {

        TeacherResponse response = new TeacherResponse(teacher.getId(),
                teacher.getEmail(), teacher.getCourse(), teacher.getAge(), teacher.getAssignedStudents().stream().toList());

        return response;
    }
    private List<TeacherResponse> modelToResponse(List<Teacher>teachers) {

        return teachers.stream().map(this::modelToResponse
        ).collect(Collectors.toList());

    }

    private Teacher requestToModel(TeacherRequest teacherRequest) {

        List<Student> students = new ArrayList<>();
        for(String studentName: teacherRequest.getStudentsName()){

            students.add(studentService.studentRepository.findById(studentName).get());

        }

        Teacher teacher;
        teacher = new Teacher(teacherRequest.getId(), teacherRequest.getDob()
                , teacherRequest.getEmail(), 30, teacherRequest.getCourse(), students);
        return teacher;

    }

    public List<TeacherResponse> read() {

       return modelToResponse(teacherRepository.findAll());
    }
    public TeacherResponse read(String id) {

        return modelToResponse(teacherRepository.findById(id).get());
    }


    public void delete(String id) {

        teacherRepository.deleteById(id);
    }

    public void update(TeacherRequest teacherRequest) {

        if(teacherRepository.existsById(teacherRequest.getId())){

           // Teacher oldTeacher = teacherRepository.findById(teacherRequest.getId()).get();
            Teacher newTeacher = requestToModel(teacherRequest);
            teacherRepository.save(newTeacher);

        }
    }
}
