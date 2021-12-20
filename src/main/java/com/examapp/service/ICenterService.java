package com.examapp.service;

import java.util.List;

import com.examapp.exceptions.CenterNotFoundException;
import com.examapp.exceptions.ExamNotFoundException;
import com.examapp.model.ExamCenter;
import org.springframework.data.jpa.repository.Query;

public interface ICenterService {

	ExamCenter addExamCenter(ExamCenter center);

	void updateCenter(ExamCenter center);

	void deleteCenter(int centerId);

	ExamCenter getById(int centerId) throws CenterNotFoundException;

	List<ExamCenter> getAll();
	
	List<ExamCenter> getByLocation(String location) throws CenterNotFoundException;
	
	List<ExamCenter> getByCenterName(String centerName) throws CenterNotFoundException;

	List<ExamCenter> getByExCenter(String examName,String center) throws CenterNotFoundException;

	List<ExamCenter> getByExLocation(String examName, String location) throws CenterNotFoundException;

	List<ExamCenter> getByExamUni(String examName, String university) throws CenterNotFoundException;

	List<ExamCenter> getByExamMarks(String examName, int marks) throws CenterNotFoundException;

	List<ExamCenter> getByUniCentSub(String subject, String examName, String university) throws CenterNotFoundException;

	List<ExamCenter> getByExCentUni(String examName, String center, String university) throws CenterNotFoundException;

	List<ExamCenter> getByLocSubNam(String location, String examName, String subject) throws CenterNotFoundException;

}
