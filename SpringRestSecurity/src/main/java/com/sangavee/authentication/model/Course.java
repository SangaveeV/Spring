package com.sangavee.authentication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "RestCourse")
@SequenceGenerator(allocationSize = 1,name = "COUR_SEQ", sequenceName ="cour_seq")
public class Course {
	@Id
	@GeneratedValue(generator = "COUR_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private List<Student> student;
	
	public Course() {
	}

	public Course(int id, String name, String description, List<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.student = student;
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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

}
