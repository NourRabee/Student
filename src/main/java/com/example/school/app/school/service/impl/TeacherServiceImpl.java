package com.example.school.app.school.service.impl;

import com.example.school.app.school.common.service.impl.BaseServiceImpl;
import com.example.school.app.school.dto.TeacherRequest;
import com.example.school.app.school.dto.TeacherResponse;
import com.example.school.app.school.model.Student;
import com.example.school.app.school.model.Teacher;
import com.example.school.app.school.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl extends BaseServiceImpl<TeacherRequest,
        Teacher, TeacherResponse, String>{

    private final TeacherRepository teacherRepository;
    private final StudentServiceImpl studentServiceImpl;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentServiceImpl studentServiceImpl) {
        this.teacherRepository = teacherRepository;
        this.studentServiceImpl = studentServiceImpl;
    }
     public TeacherResponse modelToResponse(Teacher teacher) {

        TeacherResponse response = new TeacherResponse(teacher.getId(),
                teacher.getEmail(), teacher.getCourse(), teacher.getAge(), teacher.getAssignedStudents().stream().toList());

        return response;
    }
    public List<TeacherResponse> modelToResponse(List<Teacher>teachers) {

        return teachers.stream().map(this::modelToResponse
        ).collect(Collectors.toList());

    }
    @Override
    public JpaRepository<Teacher, String> getRepository() {
        return teacherRepository;
    }

    public Teacher requestToModel(TeacherRequest teacherRequest) {

        List<Student> students = new ArrayList<>();
        for(String studentName: teacherRequest.getStudentsName()){

            students.add(studentServiceImpl.studentRepository.findById(studentName).get());

        }

        Teacher teacher = new Teacher();
        teacher.setId(teacherRequest.getId());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setDob(teacherRequest.getDob());
        teacher.setCourse(teacherRequest.getCourse());
        teacher.setAge(30);
        teacher.setAssignedStudents(students);
        return teacher;

    }

}
