package com.example.school.app.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
    @Id
    private String id;
    private LocalDate dob;
    private String email;
    private Integer age;

}
