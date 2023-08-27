package com.example.school.app.school.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
