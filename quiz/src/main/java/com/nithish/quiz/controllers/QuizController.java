package com.nithish.quiz.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithish.quiz.entitys.Question;
import com.nithish.quiz.entitys.Quiz;
import com.nithish.quiz.entitys.QuizCreateObject;
import com.nithish.quiz.entitys.QuizDetails;
import com.nithish.quiz.quizService.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/create")
	public String createQuiz(@RequestBody QuizCreateObject quizCreateObject) {
	//	hello
	//	return quizService.getQuestionsBySubject(quizCreateObject.getSubject());
       System.out.println("hello world");
		
		return quizService.getQuestionsBySubject(quizCreateObject.getSubject());

	}

}
