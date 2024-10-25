package com.nithish.quiz.entitys;


import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz_details")
public class QuizDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quiz_id;
	
    @CreationTimestamp
    private Date quiz_created;
    private String participant_name;
    private int final_score;
    private int total_question;
    
    @OneToMany(mappedBy = "quizDetails")
    private List<Quiz> questionDtls;
	public List<Quiz> getQuestionDtls() {
		return questionDtls;
	}
	public void setQuestionDtls(List<Quiz> questionDtls) {
		this.questionDtls = questionDtls;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public Date getDate() {
		return quiz_created;
	}

	public void setDate(Date quiz_created) {
		this.quiz_created = quiz_created;
	}
	public String getParticipant_name() {
		return participant_name;
	}
	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}
	public int getFinal_score() {
		return final_score;
	}
	public void setFinal_score(int final_score) {
		this.final_score = final_score;
	}
	public int getTotal_question() {
		return total_question;
	}
	public void setTotal_question(int total_question) {
		this.total_question = total_question;
	}
	public Date getQuiz_created() {
		return quiz_created;
	}
	public void setQuiz_created(Date quiz_created) {
		this.quiz_created = quiz_created;
	}
    
    

}
