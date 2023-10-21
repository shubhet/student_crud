package com.example.student.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.crud.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
