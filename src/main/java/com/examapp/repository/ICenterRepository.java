package com.examapp.repository;

import java.util.List;

import com.examapp.exceptions.CenterNotFoundException;
import com.examapp.exceptions.ExamNotFoundException;
import com.examapp.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examapp.model.ExamCenter;

@Repository
public interface ICenterRepository extends JpaRepository<ExamCenter, Integer> {

    List<ExamCenter> getByLocation(String location) throws CenterNotFoundException;

    List<ExamCenter> getByCenterName(String centerName) throws CenterNotFoundException;

    @Query("from ExamCenter e inner join e.examList a where e.centerName=?2 and a.examName=?1")
    List<ExamCenter> getByExCenter(String examName, String center) throws CenterNotFoundException;

    @Query("from ExamCenter e inner join e.examList a where e.location=?2 and a.examName=?1")
    List<ExamCenter> getByExLocation(String examName, String location) throws CenterNotFoundException;

    @Query("from ExamCenter e inner join e.examList a  inner join a.questionList r where r.university=?2 and a.examName=?1")
    List<ExamCenter> getByExamUni(String examName, String university) throws CenterNotFoundException;

	@Query("from ExamCenter e inner join e.examList a  inner join a.questionList r where r.marksDedicated>=?2 and a.examName=?1")
	List<ExamCenter> getByExamMarks(String examName, int marks) throws CenterNotFoundException;

	@Query("from ExamCenter e inner join e.examList a inner join a.questionList r where a.examName=?2 and r.university=?3 and r.subject=?1")
	List<ExamCenter> getByUniCentSub(String subject, String examName, String university) throws CenterNotFoundException;

    @Query("from ExamCenter e inner join e.examList a inner join a.questionList r where e.centerName=?2 and a.examName=?1 and r.university=?3")
    List<ExamCenter> getByExCentUni(String examName, String center, String university) throws CenterNotFoundException;

    @Query("from ExamCenter e inner join e.examList a inner join a.questionList r where a.examName=?2 and r.subject>?3 and e.location=?1")
    List<ExamCenter> getByLocSubNam(String location, String examName, String subject) throws CenterNotFoundException;


}
