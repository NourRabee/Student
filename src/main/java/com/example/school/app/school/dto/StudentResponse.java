package com.example.school.app.school.dto;

import com.example.school.app.school.common.dto.BaseRequest;
import com.example.school.app.school.common.dto.BaseResponse;
import com.example.school.app.school.model.Teacher;
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
public class StudentResponse extends BaseResponse {
    private String id;
    private String email;
    private String dob;
}
