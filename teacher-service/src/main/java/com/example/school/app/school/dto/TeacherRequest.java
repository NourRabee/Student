package com.example.school.app.school.dto;

import com.example.school.app.school.common.dto.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherRequest extends BaseRequest<String>{

    private String id;
    private String email;
    private String dob;
    private String course;
    private List<String> studentsName;
}
