package com.example.school.app.school.dto;

import com.example.school.app.school.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherResponse {

    private String id;
    private String email;
    private String course;
    private Integer age;
    private List<Student> assignedStudents;

}