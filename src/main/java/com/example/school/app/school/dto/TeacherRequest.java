package com.example.school.app.school.dto;
import com.example.school.app.school.model.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherRequest {

    private String id;
    private String email;
    private String dob;
    private String course;
    private List<String> studentsName;
}
