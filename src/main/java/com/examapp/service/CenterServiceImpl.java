package com.examapp.service;

import java.util.List;

import com.examapp.exceptions.CenterNotFoundException;
import com.examapp.exceptions.ExamNotFoundException;
import com.examapp.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examapp.model.ExamCenter;
import com.examapp.repository.ICenterRepository;

@Service
public class CenterServiceImpl implements ICenterService {

	ICenterRepository centerRepository;

	@Autowired
	public void setCenterRepository(ICenterRepository centerRepository) {
		this.centerRepository = centerRepository;
	}

	@Override
	public ExamCenter addExamCenter(ExamCenter center) {
		// TODO Auto-generated method stub
		return centerRepository.save(center);
	}

	@Override
	public void updateCenter(ExamCenter center) {
		centerRepository.save(center);
	}

	@Override
	public void deleteCenter(int centerId) {
		// TODO Auto-generated method stub
		centerRepository.deleteById(centerId);
	}

	@Override
	public ExamCenter getById(int questionId) throws CenterNotFoundException{
		// TODO Auto-generated method stub
		return centerRepository.findById(questionId).orElseThrow(()->{
			throw new CenterNotFoundException("Invalid Id");
		});
	}

	@Override
	public List<ExamCenter> getAll() {
		// TODO Auto-generated method stub
		return centerRepository.findAll();
	}

	@Override
	public List<ExamCenter> getByLocation(String location) throws CenterNotFoundException {
		// TODO Auto-generated method stub
		List<ExamCenter> center = centerRepository.getByLocation(location);
		if(center.isEmpty()){
			throw new CenterNotFoundException("Location not available");
		}
		return center;
	}

	@Override
	public List<ExamCenter> getByCenterName(String centerName) throws CenterNotFoundException {
		List<ExamCenter> center = centerRepository.getByCenterName(centerName);
		if(center.isEmpty()){
			throw new CenterNotFoundException("Exam center not available");
		}
		return center;
	}

	@Override
	public List<ExamCenter> getByExCenter(String examName, String center) throws CenterNotFoundException {
		List<ExamCenter> examCenters = centerRepository.getByExCenter(examName,center);
		if(center.isEmpty()){
			throw new CenterNotFoundException("Fault in exam name or center name");
		}
		return examCenters;
	}

	@Override
	public List<ExamCenter> getByExLocation(String examName, String location) throws CenterNotFoundException {
		List<ExamCenter>centers = centerRepository.getByExLocation(examName, location);
		if(centers.isEmpty()){
			throw new CenterNotFoundException("location or exam name mismatch");
		}
		return centers;
	}

	@Override
	public List<ExamCenter> getByExamUni(String examName, String university) throws CenterNotFoundException {
		List<ExamCenter> centers = centerRepository.getByExamUni(examName, university);
		if(centers.isEmpty()){
			throw new CenterNotFoundException("No exam is conducted under this");
		}
		return centers;
	}

	@Override
	public List<ExamCenter> getByExamMarks(String examName, int marks) throws CenterNotFoundException {
		List<ExamCenter> centers = centerRepository.getByExamMarks(examName, marks);
		if(centers.isEmpty()){
			throw new CenterNotFoundException("marks incorrect");
		}
		return centers;
	}

	@Override
	public List<ExamCenter> getByUniCentSub(String subject, String examName, String university) throws CenterNotFoundException {
		List<ExamCenter> centers = centerRepository.getByUniCentSub(subject, examName, university);
		if(centers.isEmpty()){
			throw new CenterNotFoundException("No Center conducted exam in this subject");
		}
		return centers;
	}

	@Override
	public List<ExamCenter> getByExCentUni(String examName, String center, String university) throws CenterNotFoundException {
		List<ExamCenter> centers = centerRepository.getByExCentUni(examName, center, university);
		if(centers.isEmpty()){
			throw new CenterNotFoundException("No university asked questions in this exam");
		}
		return centers;
	}

	@Override
	public List<ExamCenter> getByLocSubNam(String location, String examName, String subject) throws CenterNotFoundException {
		List<ExamCenter> centers = centerRepository.getByLocSubNam(location,examName,subject);
		if(centers.isEmpty()){
			throw new CenterNotFoundException("No exam conducted in this location");
		}
		return centers;
	}

}
