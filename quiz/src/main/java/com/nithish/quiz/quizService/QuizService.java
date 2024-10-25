package com.nithish.quiz.quizService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithish.quiz.entitys.Question;
import com.nithish.quiz.entitys.Quiz;
import com.nithish.quiz.entitys.QuizCreateObject;
import com.nithish.quiz.entitys.QuizDetails;
import com.nithish.quiz.quizRepo.QuestionsRepo;
import com.nithish.quiz.quizRepo.QuizDetailsRepo;
import com.nithish.quiz.quizRepo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	private QuestionsRepo questionsRepo;
	
	@Autowired
	private QuizDetailsRepo quizDetailsRepo;
	
	@Autowired
	private QuizRepo quizRepo;
	
	public String getQuestionsBySubject(String quizCreateSubject) {
		
		//using question service
		List<Question> listOfQues=questionsRepo.getByquestionSubject(quizCreateSubject);
		QuizDetails quizDetails=new QuizDetails();
		List<Quiz> quizList=new ArrayList<>();	
		quizDetails.setParticipant_name("nithish");
		
		QuizDetails quizDetailsObj = createQuizDetais(quizDetails);
		
		listOfQues.forEach( t -> {
			Quiz quiz=new Quiz();
			quiz.setQuizDetails(quizDetailsObj);
			quiz.setQuestion_id(t.getId());
			quizList.add(quiz);			
			t.getQuestion_name();
		});
		
		quizRepo.saveAll(quizList);
		return "success";
		
	}
	
	
	public QuizDetails createQuizDetais(QuizDetails quizDetails) {
		return quizDetailsRepo.save(quizDetails);		
	}

}
