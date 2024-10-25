package com.nithish.quiz.quizRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nithish.quiz.entitys.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
