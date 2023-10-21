package com.example.student.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.student.crud.models.Student;
import com.example.student.crud.service.StudentService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class StudentController {
	 
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
		Student  saveStudent = studentService.createStudent(student);
		return new ResponseEntity<>(saveStudent,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAllstudents")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> studentList = (List) studentService.getAllStudents();
		return new ResponseEntity<>(studentList,HttpStatus.OK);
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer studentId){
		 Student student = studentService.getStudentById(studentId);
		 return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteStudentById/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable("id") Integer studentId){
		Student student = studentService.getStudentById(studentId);
	    studentService.deleteStudent(studentId);
	    return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	
	@PutMapping("/upadteStuduent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") Integer studentId){
		Student updatedStudent = studentService.updateStudent(student,studentId);
		return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
	}
	
	
	

}
