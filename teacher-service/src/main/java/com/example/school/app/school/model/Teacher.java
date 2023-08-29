package com.example.school.app.school.model;

import com.example.school.app.school.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Teacher extends BaseModel<String>{

    @Id
    private String id;
    private int age;
    private String course;

    @ManyToMany
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    private Collection<Student> assignedStudents= new ArrayList<>();

}
