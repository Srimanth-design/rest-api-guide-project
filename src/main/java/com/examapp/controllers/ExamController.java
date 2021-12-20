package com.examapp.controllers;


import com.examapp.exceptions.ExamNotFoundException;
import com.examapp.model.Exam;
import com.examapp.service.IExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.List;

@RestController
public class ExamController {

    IExamService examService;

    private Logger logger = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    public void setExamService(IExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/admin/exams")
    ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding Exam");
        Exam exam1 = examService.addExam(exam);
        return ResponseEntity.status(HttpStatus.CREATED).body(exam1);
    }

    @PutMapping("/admin/exams")
    ResponseEntity<Void> updateExam(@RequestBody Exam exam) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding Exam");
        examService.updateExam(exam);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/admin/examId/{examId}")
    ResponseEntity<String> deleteExam(@PathVariable("examId") int examId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding Exam");
        examService.deleteExam(examId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");

    }

    @GetMapping("/exams")
    ResponseEntity<Set<Exam>> getAll(){
        logger.debug("inside get all questions");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all exams");
        headers.add("info", "exam details");
        List<Exam> exams = examService.getAll();
        logger.info("Got all questions: " + exams);
        ResponseEntity<Set<Exam>> examResponse = new ResponseEntity(exams, headers, HttpStatus.OK);
        return examResponse;
    }

    @GetMapping("/exams/examId/{examId}")
    ResponseEntity<Exam> getById(@PathVariable("examId") int examId) throws ExamNotFoundException {
        logger.debug("inside get answer by Id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Exam Id ");
        Exam exam = examService.getById(examId);
        logger.info("Got one exam details " + exam);
        return ResponseEntity.ok().headers(headers).body(exam);
    }

    @GetMapping("/exams/examName/{examName}")
    ResponseEntity<Set<Exam>> getByExamName(@PathVariable("examName") String examName) throws ExamNotFoundException {
        logger.debug("inside get exam details by name");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by exam name");
        Set<Exam> exams = examService.getByExamName(examName);
        logger.info("Got exam details by name: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/name/{name}/topic/{topic}")
    ResponseEntity<Set<Exam>> getByNameAndTopic(@PathVariable("name") String name, @PathVariable("topic") String topic) throws ExamNotFoundException {
        logger.debug("inside get question by name and topic details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by name and topic");
        Set<Exam> exams = examService.getByNameAndTopic(name, topic);
        logger.info("Got exam details by name and topic: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);

    }

    @GetMapping("/exams/name/{name}/subject/{subject}")
    ResponseEntity<Set<Exam>> getByNameAndSubject(@PathVariable("name") String name,@PathVariable("subject") String subject) throws ExamNotFoundException{
        logger.debug("inside get question by name and subject details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by name and subject");
        Set<Exam> exams = examService.getByNameAndSubject(name, subject);
        logger.info("Got exam details by name and subject: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/topic/{topic}/subject/{subject}/examName/{examName}")
    ResponseEntity<Set<Exam>> getByTopicAndSubject(@PathVariable("topic") String topic,@PathVariable("subject") String subject,@PathVariable("examName") String examName) throws  ExamNotFoundException{
        logger.debug("inside get question by topic and subject and exam name ");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by topic and subject and exam name");
        Set<Exam> exams = examService.getByTopicSubName(topic,subject,examName);
        logger.info("Got exam details by topic and subject and exam name: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/error/{error}/university/{university}/lineCount/{lineCount}")
    ResponseEntity<Set<Exam>> getByErrUniCount(@PathVariable("error") int spellError,@PathVariable("university") String university,@PathVariable("lineCount") int lineCount) throws ExamNotFoundException{
        logger.debug("inside get question by name, university and line count");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by name, university and line count");
        Set<Exam> exams = examService.getByErrUniCount(spellError, university, lineCount);
        logger.info("Got exam details by name,university and line count: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/university/{university}/name/{name}")
    ResponseEntity<Set<Exam>> getByUniAndName(@PathVariable("university") String university,@PathVariable("name") String name) throws ExamNotFoundException{
        logger.debug("inside get question by name and university details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by name and subject");
        Set<Exam> exams = examService.getByUniAndName(university,name);
        logger.info("Got exam details by name and subject: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/marks/{marks}/name/{name}")
    ResponseEntity<Set<Exam>> getByMarksAndName(@PathVariable("marks") int marks,@PathVariable("name") String name) throws ExamNotFoundException{
        logger.debug("inside get question by name and marks details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by exam name and marks");
        Set<Exam> exams = examService.getByMarksAndName(marks, name);
        logger.info("Got exam details by exam name and marks : " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/examName/{examName}/subject/{subject}/lineCount/{lineCount}")
    ResponseEntity<Set<Exam>> getByNameSubTime(@PathVariable("examName") String examName, @PathVariable("subject") String subject,@PathVariable("lineCount") int lineCount) throws ExamNotFoundException{
        logger.debug("inside get question by name and subject details and answer");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by name,subject and answer");
        Set<Exam> exams = examService.getByNameSubTime(examName, subject, lineCount);
        logger.info("Got exam details by name,subject and answer: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

    @GetMapping("/exams/examName/{examName}/subject/{subject}/errors/{errors}")
    ResponseEntity<Set<Exam>> getByNameSubError(@PathVariable("examName") String examName,@PathVariable("subject") String subject,@PathVariable("errors") Integer errors) throws ExamNotFoundException{
        logger.debug("inside get question by name and subject details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by name and subject");
        Set<Exam> exams = examService.getByNameSubError(examName, subject, errors);
        logger.info("Got exam details by name and subject: " + exams);
        return ResponseEntity.ok().headers(headers).body(exams);
    }

}
