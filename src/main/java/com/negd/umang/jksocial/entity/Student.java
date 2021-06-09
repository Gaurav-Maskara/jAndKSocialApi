package com.negd.umang.jksocial.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="hello_id")
	private Passport passport;
	
	//@ManyToMany  ---Note : In this case a new third table is formed named course_student with course_id and student_id as columns, if only @ManyToMany is written over both the classes
	//private List<Course> courses = new ArrayList<Course>();
	
	//@ManyToMany  ---Note : In this case a new third table , named student_courses, with course_id and student_id as columns, if @ManyToMany (mappedBy="courses") , is written on Course.class
	//private List<Course> courses = new ArrayList<Course>();
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", 
	joinColumns = @JoinColumn(name = "STUDENT_ID"), 
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<Course>();
	
	
	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public Long getId() {
		return id;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
}