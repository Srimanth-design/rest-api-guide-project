package com.examapp.service;

import java.util.List;
import java.util.Set;
import java.util.Set;

import com.examapp.exceptions.ExamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examapp.model.Exam;

import com.examapp.repository.IExamRepository;

@Service
public class ExamServiceImpl implements IExamService {

    IExamRepository examRepository;

    @Autowired
    public void setExamRepository(IExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Exam addExam(Exam exam) {
        // TODO Auto-generated method stub
        return examRepository.save(exam);
    }

    @Override
    public void updateExam(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void deleteExam(int examId) {
        // TODO Auto-generated method stub
        examRepository.deleteById(examId);
    }

    @Override
    public Exam getById(int examId) throws ExamNotFoundException {
        // TODO Auto-generated method stub
        return examRepository.findById(examId).orElseThrow(() -> {
            throw new ExamNotFoundException("Invalid id");
        });
    }

    @Override
    public List<Exam> getAll() {
        return examRepository.findAll();
    }


    @Override
    public Set<Exam> getByExamName(String name) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByExamName(name);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("Exam is unassigned");
        }
        return exams;

    }

    @Override
    public Set<Exam> getByNameAndTopic(String name, String topic) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByNameAndTopic(name, topic);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("Name or topic is unmatched");
        }
        return exams;
    }

    @Override
    public Set<Exam> getByNameAndSubject(String name, String subject) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByNameAndSubject(name, subject);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No exam conducted with on this subject");
        }
        return exams;
    }

    @Override
    public Set<Exam> getByTopicSubName(String topic, String subject, String examName) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByTopicSubName(topic, subject, examName);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No exam under this combination");
        }
        return exams;
    }

    @Override
    public Set<Exam> getByErrUniCount(int spellError, String university, int lineCount) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByErrUniCount(spellError, university, lineCount);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No exam under this combination");
        }
        return exams;
    }


    @Override
    public Set<Exam> getByUniAndName(String university, String name) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByUniAndName(university, name);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No questions asked from this university");
        }
        return exams;
    }

    @Override
    public Set<Exam> getByMarksAndName(int marks, String name) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByMarksAndName(marks, name);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No exam found");
        }
        return exams;
    }


    @Override
    public Set<Exam> getByNameSubTime(String examName, String subject, int lineCount) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByNameSubTime(examName, subject, lineCount);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No exam found in this combination");
        }
        return exams;
    }

    @Override
    public Set<Exam> getByNameSubError(String examName, String subject, Integer errors) throws ExamNotFoundException {
        Set<Exam> exams = examRepository.getByNameSubError(examName, subject, errors);
        if (exams.isEmpty()) {
            throw new ExamNotFoundException("No exam found in this combination");
        }
        return exams;
    }


}
