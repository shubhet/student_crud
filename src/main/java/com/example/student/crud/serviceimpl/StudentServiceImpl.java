package com.example.student.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.crud.models.Student;
import com.example.student.crud.repository.StudentRepository;
import com.example.student.crud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).orElseThrow();
		return studentRepository.getById(studentId);
	}

	@Override
	public Student deleteStudent(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).orElseThrow();
		this.studentRepository.delete(student);
		return student;
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	
}
