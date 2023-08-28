package com.example.school.app.school.model;

import com.example.school.app.school.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student extends BaseModel<String> {
    @Id
    private String id;
    private Integer age;

}
