package com.example.student.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.student.crud.exception.ResourceNotFoundException;
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
		Student student = this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("StudentId",studentId));
		return studentRepository.getById(studentId);
	}

	@Override
	public void deleteStudent(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student Id", studentId));
		this.studentRepository.delete(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student updateStudent(Student student,Integer studentId) {
		Student existingStudent = this.studentRepository.findById(studentId).orElseThrow();
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setMobile(student.getMobile());
		return studentRepository.save(existingStudent);
		
	}

	
}
