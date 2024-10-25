package com.nithish.quiz.quizRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nithish.quiz.entitys.QuizDetails;

public interface QuizDetailsRepo extends JpaRepository<QuizDetails, Integer> {

}
