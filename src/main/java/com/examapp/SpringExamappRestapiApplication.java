package com.examapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examapp.model.Answer;
import com.examapp.model.Exam;
import com.examapp.model.ExamCenter;
import com.examapp.model.Question;
import com.examapp.service.ICenterService;
import com.examapp.service.IExamService;
import com.examapp.service.IQuestionService;

@SpringBootApplication
public class SpringExamappRestapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringExamappRestapiApplication.class, args);
    }

    ICenterService centerService;
    IExamService examService;
    IQuestionService questionService;

    @Autowired
    public void setCenterService(ICenterService centerService) {
        this.centerService = centerService;
    }

    @Autowired
    public void setExamService(IExamService examService) {
        this.examService = examService;
    }

    @Autowired
    public void setQuestionService(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        Answer answer = new Answer("Living for years without living at all", 14, 1);
        Question question = new Question("What a senseless person do ?", "LifeScience", "General", 50, "BSR College",
                answer);
        // questionService.addQuestion(question);

        Answer answer2 = new Answer("Go through it and learn from it", 16, 2);
        Question question2 = new Question("How to deal a situation ?", "Better living", "Family", 40, "AVSR", answer2);
        // questionService.addQuestion(question2);

        Answer answer3 = new Answer("They share whatever they see", 13, 2);
        Question question3 = new Question("What mothers do with whatsapp?", "Communication", "Mother", 50, "KKIR",
                answer3);
        // questionService.addQuestion(question3);

        Answer answer4 = new Answer("Which helps in not choosing medicine", 19, 2);
        Question question4 = new Question("What is Biology ?", "Science", "Biology", 50, "Saithan", answer4);
        // questionService.addQuestion(question4);

        Answer answer5 = new Answer(
                "Set your alarm clock slow",
                10, 2);
        Question question5 = new Question("How to run fast ?", "Life", "Run", 60, "Gorantla",
                answer5);
        // questionService.addQuestion(question5);

        Answer answer6 = new Answer("Nod your head for whatever they say", 19, 6);
        Question question6 = new Question("How to deal with kids?", "LifeScience", "General", 50, "Camunda", answer6);
        // questionService.addQuestion(question6);

        Set<Question> questionList = new HashSet<>(Arrays.asList(question, question2, question3));
        Set<Question> questionList2 = new HashSet<>(Arrays.asList(question4, question5, question6));

        //examService.deleteExam(104);



//        Exam exam = examService.getById(103);
//        ExamCenter center = centerService.getById(201);
//        Set<Exam> list1 = center.getExamList();
//        //Set<Exam> examList = new HashSet<>(Arrays.asList(exam));
//        list1.add(exam);
//        center.setExamList(list1);
//        centerService.updateCenter(center);


        //**

//        Exam exam = new Exam("Quarterly", "30 min", questionList);
//        Exam exam1 = new Exam("Mid", "30 min", questionList2);
//        Set<Exam> examList = new HashSet<>(Arrays.asList(exam1));

        //ExamCenter center = new ExamCenter("MRIS College", "Nellore", examList);
//		//centerService.getById()
        //ExamCenter center = centerService.getById(200);

        //examService.getByExamName("Annual").forEach(System.out::println);
        // centerService.addExamCenter(center);

    }

}
