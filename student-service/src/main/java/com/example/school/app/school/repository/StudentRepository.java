package com.example.school.app.school.repository;

import com.example.school.app.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

}
