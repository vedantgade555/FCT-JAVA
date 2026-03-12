package com.example.start.bean;

public class Student {
	private int id;
	private String name;
	private double Marks;

	public Student() {

	}

	public Student(int id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		Marks = marks;
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

	public double getMarks() {
		return Marks;
	}

	public void setMarks(double marks) {
		Marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Marks=" + Marks + "]";
	}

}
