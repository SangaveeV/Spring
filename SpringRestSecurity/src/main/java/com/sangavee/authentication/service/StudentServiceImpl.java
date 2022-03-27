package com.sangavee.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sangavee.authentication.model.Student;
import com.sangavee.authentication.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student getStudent(int studentId) {
		if(studentRepository.findById(studentId).isPresent()) {
			return studentRepository.findById(studentId).get();
		}
		return null;
	}

	@Override
	public List<Student> getStudentByCourseId(int courseId) {
		return studentRepository.findByCourseId(courseId);
	}

}
