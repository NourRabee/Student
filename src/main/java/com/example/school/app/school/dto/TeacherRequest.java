package com.example.school.app.school.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherRequest {

    private String id;
    private String email;
    private LocalDate dob;
    private String course;
}
