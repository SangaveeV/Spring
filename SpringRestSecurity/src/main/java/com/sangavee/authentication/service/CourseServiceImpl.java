package com.sangavee.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sangavee.authentication.model.Course;
import com.sangavee.authentication.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course getCourse(int id) {
		return courseRepository.getById(id);
	}

}
