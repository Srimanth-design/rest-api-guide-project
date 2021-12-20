package com.examapp.service;

import java.util.List;

import com.examapp.exceptions.QuestionNotFoundException;
import com.examapp.model.Question;

public interface IQuestionService {

	Question addQuestion(Question question);

	void updateQuestion(Question question);

	void deleteQuestion(int questionId);

	Question getById(int questionId) throws QuestionNotFoundException;

	List<Question> getAll();

	List<Question> getBySubject(String subject) throws QuestionNotFoundException;

	List<Question> getByTopic(String topic) throws QuestionNotFoundException;

	List<Question> getByTopicAndSub(String topic, String subject) throws QuestionNotFoundException;

	List<Question> getByMarksAndUni(int marksDedicated, String university) throws QuestionNotFoundException;

	List<Question> getByCount(int lineCount) throws QuestionNotFoundException;

	List<Question> getByMarksAndCount(int marks, int count) throws QuestionNotFoundException;

	List<Question> getByErrorCount(int error) throws QuestionNotFoundException;

	List<Question> getByLineCountError(int count, int error) throws QuestionNotFoundException;

	List<Question> findByCountError(int marks, int error) throws QuestionNotFoundException;
}
