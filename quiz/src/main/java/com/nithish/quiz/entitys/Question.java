package com.nithish.quiz.entitys;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	private int id;
	private String question_name;
	private String option1;
	private String option2;
	private String option3;
	private String option4;	
    private int correct_option;
    private String question_level; 
    private String questionSubject;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public int getCorrect_option() {
		return correct_option;
	}
	public void setCorrect_option(int correct_option) {
		this.correct_option = correct_option;
	}
	public String getQuestion_level() {
		return question_level;
	}
	public void setQuestion_level(String question_level) {
		this.question_level = question_level;
	}
	public String getQuestionSubject() {
		return questionSubject;
	}
	public void setQuestionSubject(String questionSubject) {
		this.questionSubject = questionSubject;
	}

}
