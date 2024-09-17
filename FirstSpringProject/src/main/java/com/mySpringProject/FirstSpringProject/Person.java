package com.mySpringProject.FirstSpringProject;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private int id;
	private String name;
	
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
	
	public void printPersonName() {
		System.out.println("nithish");
	}
}
