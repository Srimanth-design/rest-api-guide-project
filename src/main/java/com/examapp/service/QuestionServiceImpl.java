package com.examapp.service;

import java.util.List;

import com.examapp.exceptions.QuestionNotFoundException;
import com.examapp.repository.IQuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examapp.model.Question;

@Service
public class QuestionServiceImpl implements IQuestionService {

	private Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

	IQuestionRepository questionRepository;

	@Autowired
	public void setQuestionRepository(IQuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public void updateQuestion(Question question) {
		questionRepository.save(question);

	}

	@Override
	public void deleteQuestion(int questionId) {
		questionRepository.deleteById(questionId);
	}

	@Override
	public Question getById(int questionId) throws QuestionNotFoundException {
		// TODO Auto-generated method stub
		logger.debug("inside get property by id method in service layer");
		logger.info("calling get property by id method");

		return questionRepository.findById(questionId).orElseThrow(()->{
			//logger.error("Question not found exception occured - invalid id");
			throw new QuestionNotFoundException("Invalid id");
		});
	}

	@Override
	public List<Question> getAll() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

//	@Override
//	public List<Question> findByType(String type) throws QuestionNotFoundException {
//		List<Question> questions = questionRepository.findByType(type);
//		if(questions.isEmpty()){
//			throw new QuestionNotFoundException("Question not asked");
//		}
//		return questions;
//	}

//	@Override
//	public List<Question> getByQues(String question) throws QuestionNotFoundException{
//		// TODO Auto-generated method stub
//		List<Question> questions = questionRepository.findByQues(question);
//		if(questions.isEmpty()){
//			throw new QuestionNotFoundException("Question not available");
//		}
//		return questions;
//	}

	@Override
	public List<Question> getBySubject(String subject) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findBySubject(subject);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("Subject not available");
		}
		return questions;
	}

	@Override
	public List<Question> getByTopic(String topic) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findByTopic(topic);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("Topic not available");
		}
		return questions;
	}

	@Override
	public List<Question> getByTopicAndSub(String topic, String subject) throws QuestionNotFoundException{
		List<Question> questions = questionRepository.findByTopicAndSubject(topic, subject);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("Topic or subject not available");
		}
		return questions;
	}

	@Override
	public List<Question> getByMarksAndUni(int marksDedicated, String university) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findByMarksAndUni(marksDedicated, university);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("Marks are not in sync with this university");
		}
		return questions;
	}

	@Override
	public List<Question> getByCount(int lineCount) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findByCount(lineCount);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("Line count is beyond");
		}
		return questions;
	}

	@Override
	public List<Question> getByMarksAndCount(int marks, int count) throws  QuestionNotFoundException {
		List<Question> questions = questionRepository.findByMarksAndCount(marks, count);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("marks or count not in sync");
		}
		return questions;
	}

	@Override
	public List<Question> getByErrorCount(int error) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findByErrorCount(error);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("errors are not in permissible limits");
		}
		return questions;
	}

	@Override
	public List<Question> getByLineCountError(int count, int error) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findByLineCountError(count, error);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("line count or error count mismatch");
		}
		return questions;
	}

	@Override
	public List<Question> findByCountError(int marks, int error) throws QuestionNotFoundException {
		List<Question> questions = questionRepository.findByCountError(marks, error);
		if(questions.isEmpty()){
			throw new QuestionNotFoundException("error mismatch");
		}
		return questions;
	}

}
