package com.example.school.app.school.dto;

import com.example.school.app.school.common.dto.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentResponse extends BaseResponse {
    private String id;
    private String email;
    private String dob;
}
