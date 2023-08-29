package com.example.school.app.school.model;

import com.example.school.app.school.common.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
