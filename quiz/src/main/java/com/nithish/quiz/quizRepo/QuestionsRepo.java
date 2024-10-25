package com.nithish.quiz.quizRepo;

import java.beans.BeanProperty;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nithish.quiz.entitys.Question;

import jakarta.persistence.Column;

public interface QuestionsRepo extends JpaRepository<Question, Integer> {
	
	List<Question> getByquestionSubject(String question_subject);

}
