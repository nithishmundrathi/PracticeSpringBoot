package com.nithish.quiz.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id ;

	private int question_id;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private QuizDetails quizDetails;
	
	public QuizDetails getQuizDetails() {
		return quizDetails;
	}
	public void setQuizDetails(QuizDetails quizDetails) {
		this.quizDetails = quizDetails;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	
	
}
