package com.example.student.crud.service;

import java.util.List;

import com.example.student.crud.models.Student;

public interface StudentService {
	
	Student createStudent(Student student);
	
	Student getStudentById(Integer studentId);
	
	void deleteStudent(Integer studentId);

	List<Student> getAllStudents();
	
	Student updateStudent(Student student, Integer studentId);

}
