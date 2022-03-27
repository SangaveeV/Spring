package com.sangavee.authentication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "RestStudent")
@SequenceGenerator(name="STUD_SEQ",sequenceName = "stud_seq",allocationSize = 1)
public class Student {
	@Id
	@GeneratedValue(generator = "STUD_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String description;
	
	@ManyToOne
	private Course course;

	public Student() {
	}

	public Student(int id, String name, String description, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}