package com.examapp.service;

import java.util.List;
import java.util.Set;
import java.util.Set;

import com.examapp.exceptions.ExamNotFoundException;
import com.examapp.model.Exam;


public interface IExamService {

    Exam addExam(Exam exam);

    void updateExam(Exam exam);

    void deleteExam(int examId);

    Exam getById(int examId) throws ExamNotFoundException;

    List<Exam> getAll();

    Set<Exam> getByExamName(String name) throws ExamNotFoundException;

    Set<Exam> getByNameAndTopic(String name, String topic) throws ExamNotFoundException;

    Set<Exam> getByNameAndSubject(String name, String subject) throws ExamNotFoundException;

    Set<Exam> getByTopicSubName(String topic, String subject, String examName) throws  ExamNotFoundException;

    Set<Exam> getByErrUniCount(int spellError,String university,int lineCount) throws ExamNotFoundException;

    Set<Exam> getByUniAndName(String university, String name) throws ExamNotFoundException;

    Set<Exam> getByMarksAndName(int marks, String name) throws ExamNotFoundException;

    Set<Exam> getByNameSubTime(String examName,String subject,int lineCount) throws ExamNotFoundException;

    Set<Exam> getByNameSubError(String examName,String subject,Integer errors) throws ExamNotFoundException;

}
