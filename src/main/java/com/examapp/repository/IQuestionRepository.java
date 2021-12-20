package com.examapp.repository;

import java.util.List;

import com.examapp.exceptions.QuestionNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examapp.model.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findBySubject(String subject) throws QuestionNotFoundException;

	List<Question> findByTopic(String topic) throws QuestionNotFoundException;

	List<Question> findByTopicAndSubject(String topic, String subject) throws QuestionNotFoundException;

	@Query("from Question where marksDedicated<=?1 and university=?2")
	List<Question> findByMarksAndUni(int marksDedicated, String university) throws QuestionNotFoundException;

	@Query("from Question q inner join q.answer a where a.lineCount>?1")
	List<Question> findByCount(int lineCount) throws QuestionNotFoundException;

	@Query("from Question q inner join q.answer a where a.spellError>=?1")
	List<Question> findByErrorCount(int error) throws QuestionNotFoundException;

	@Query("from Question s inner join s.answer a where s.marksDedicated>=?1 and a.lineCount>?2")
	List<Question> findByMarksAndCount(int marks, int count) throws QuestionNotFoundException;

	@Query("from Question s inner join s.answer a where a.lineCount>=?1 and a.spellError>?2")
	List<Question> findByLineCountError(int count, int error) throws QuestionNotFoundException;

	@Query("from Question s inner join s.answer a where s.marksDedicated>=?1 and a.spellError>?2")
	List<Question> findByCountError(int marks, int error) throws QuestionNotFoundException;

}
