package com.example.school.app.school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherResponse {

    private String id;
    private String email;
    private String course;
    private Integer age;

}
