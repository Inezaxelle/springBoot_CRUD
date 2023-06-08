package com.example.demo.model;

public class Student {
	public Student(int studId, String firstName, String lastName, int age) {
		super();
		this.studId = studId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	private int studId;
	private String firstName;
	private String lastName;
	private int age;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
