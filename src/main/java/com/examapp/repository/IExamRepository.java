package com.examapp.repository;

import java.util.Set;
import java.util.Set;

import com.examapp.exceptions.ExamNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examapp.model.Exam;

@Repository
public interface IExamRepository extends JpaRepository<Exam, Integer> {

	Set<Exam> getByExamName(String name) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a where e.examName=?1 and a.topic=?2 ")
	Set<Exam> getByNameAndTopic(String name, String topic) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a where e.examName=?1 and a.subject=?2")
	Set<Exam> getByNameAndSubject(String name, String subject) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a where a.subject=?2 and a.topic=?1 and e.examName=?3")
	Set<Exam> getByTopicSubName(String topic, String subject,String examName) throws  ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a inner join a.answer r where a.university=?2 and r.lineCount>?3 and r.spellError<?1")
	Set<Exam> getByErrUniCount(int spellError,String university,int lineCount) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a where a.university=?1 and e.examName=?2 ")
	Set<Exam> getByUniAndName(String university, String name) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a where a.marksDedicated<=?1 and e.examName=?2 ")
	Set<Exam> getByMarksAndName(int marks, String name) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a inner join a.answer r where a.subject=?2 and r.lineCount>?3 and e.examName=?1")
	Set<Exam> getByNameSubTime(String examName,String subject,int lineCount) throws ExamNotFoundException;

	@Query("from Exam e inner join e.questionList a inner join a.answer r where a.subject=?2 and r.spellError<?3 and e.examName=?1")
	Set<Exam> getByNameSubError(String examName,String subject,Integer errors) throws ExamNotFoundException;


}
