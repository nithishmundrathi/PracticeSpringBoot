package com.mySpringProject.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dilpasand {
	private String color;
	private int size;
	private boolean status;
	@Autowired
	private Person pson;
	
	public Person getPerson() {
		return pson;
	}
	public void setPerson(Person person) {
		this.pson = person;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void showMessage() {
		System.out.println("show messge");
		pson.printPersonName();
	}


}
