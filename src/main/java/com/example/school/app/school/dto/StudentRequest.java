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
public class StudentRequest extends BaseRequest<String> {

    @Getter
    private String id;
    private String email;
    private int age;

}
