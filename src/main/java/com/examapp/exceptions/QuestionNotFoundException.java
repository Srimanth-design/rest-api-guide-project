package com.examapp.exceptions;

public class QuestionNotFoundException extends RuntimeException{

    public QuestionNotFoundException() {

        super();
    }

    public QuestionNotFoundException(String message) {
        super(message);
    }

}
