package com.sangavee.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.authentication.model.Student;
import com.sangavee.authentication.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/studentId/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id){
		Student student=studentService.getStudent(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<List<Student>> getStudentByCourse(@PathVariable int courseId){
		List<Student> students=studentService.getStudentByCourseId(courseId);
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
}
