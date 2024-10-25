package com.nithish.quiz.entitys;

import org.springframework.stereotype.Component;

@Component
public class QuizCreateObject {
	private String level;
	private String subject;
	private int noOfQuestions;
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	
	
}
