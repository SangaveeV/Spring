package com.sangavee.authentication.service;

import java.util.List;

import com.sangavee.authentication.model.Student;

public interface StudentService {

	Student getStudent(int studentId);
	List<Student> getStudentByCourseId(int courseId);
}
