package com.examapp.controllers;

import com.examapp.exceptions.QuestionNotFoundException;
import com.examapp.model.Question;
import com.examapp.service.IQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuestionController {

    private IQuestionService questionService;
    private Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    public void setQuestionService(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/admin/questions")
    ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding Question");
        Question nquestion = questionService.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(nquestion);

    }

    @PutMapping("/admin/questions")
    ResponseEntity<Void> updateQuestion(@RequestBody Question question) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a question");
        questionService.updateQuestion(question);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/admin/questions/{questionId}")
    ResponseEntity<String> deleteQuestion(@PathVariable("questionId") int questionId) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting a question");
        questionService.deleteQuestion(questionId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");


    }

    @GetMapping("/questions/id/{questionId}")
    ResponseEntity<Question> getById(@PathVariable("questionId") int questionId) {
        logger.debug("inside get question by Id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all ");
        Question question = questionService.getById(questionId);
        logger.info("Got one question " + question);
        return ResponseEntity.ok().headers(headers).body(question);
    }

    @GetMapping("/questions")
    ResponseEntity<List<Question>> getAll() {
        logger.debug("inside get all questions");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all questions");
        headers.add("info", "Question details");
        List<Question> questions = questionService.getAll();
        logger.info("Got all questions: " + questions);
        ResponseEntity<List<Question>> propertyResponse = new ResponseEntity(questions, headers, HttpStatus.OK);
        return propertyResponse;

    }

    @GetMapping("/questions/subject/{subject}")
    ResponseEntity<List<Question>> getBySubject(@PathVariable("subject") String subject) {
        logger.debug("inside get question by subject");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by subject");
        List<Question> questions = questionService.getBySubject(subject);
        logger.info("Got question by subject: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }

    @GetMapping("/questions/topic/{topic}")
    ResponseEntity<List<Question>> getByTopic(@PathVariable("topic") String topic) {
        logger.debug("inside get question by topic");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by topic");
        List<Question> questions = questionService.getByTopic(topic);
        logger.info("Got question by topic: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }

    @GetMapping("/questions/topic/{topic}/subject/{subject}")
    ResponseEntity<List<Question>> getByTopicAndSub(@PathVariable("topic") String topic,@PathVariable("subject") String subject) {
        logger.debug("inside get question by topic and subject");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by topic and subject");
        List<Question> questions = questionService.getByTopicAndSub(topic, subject);
        logger.info("Got question by topic and subject: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }


    @GetMapping("/questions/marks/{marksDedicated}/university/{university}")
    ResponseEntity<List<Question>> getByMarksAndUni(@PathVariable("marksDedicated") int marksDedicated,@PathVariable("university") String university) {
        logger.debug("inside get question by marks and university");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by marks and university");
        List<Question> questions = questionService.getByMarksAndUni(marksDedicated, university);
        logger.info("Got question by topic and subject: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }

    @GetMapping("/questions/lineCount/{lineCount}")
    ResponseEntity<List<Question>> getByCount(@PathVariable("lineCount") int lineCount) {
        logger.debug("inside get question by answer line count");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by line count");
        List<Question> questions = questionService.getByCount(lineCount);
        logger.info("Got question by answer line count: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);

    }
    @GetMapping("/questions/marks/{marks}/count/{count}")
    ResponseEntity<List<Question>> getByQuesAndCount(@PathVariable("marks") int marks,@PathVariable("count") int count) {
        logger.debug("inside get question by marks and line count");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by marks and line count");
        List<Question> questions = questionService.getByMarksAndCount(marks, count);
        logger.info("Got question by marks and line count: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }

    @GetMapping("/questions/error/{error}")
    ResponseEntity<List<Question>> getByErrorCount(@PathVariable("error") int error) {
        logger.debug("inside get question by errored answers");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by error count");
        List<Question> questions = questionService.getByErrorCount(error);
        logger.info("Got question by qa having answers: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }


    @GetMapping("/questions/count/{count}/error/{error}")
    ResponseEntity<List<Question>> getByCountError(@PathVariable("count") int count,@PathVariable("count") int error) {
        logger.debug("inside get question by line count and errored answers");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by line count and error");
        List<Question> questions = questionService.getByLineCountError(count, error);
        logger.info("Got question by line count and errored answers: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }

    @GetMapping("/questions/marks/{marks}/error/{error}")
    ResponseEntity<List<Question>> findByCountError(@PathVariable("marks") int marks,@PathVariable("error") int error) throws QuestionNotFoundException{
        logger.debug("inside get question by line count and errored answers");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting by line count and error");
        List<Question> questions = questionService.findByCountError(marks, error);
        logger.info("Got question by line count and errored answers: " + questions);
        return ResponseEntity.ok().headers(headers).body(questions);
    }
}
