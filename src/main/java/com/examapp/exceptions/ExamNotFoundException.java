package com.examapp.exceptions;

public class ExamNotFoundException extends RuntimeException{
    public ExamNotFoundException() {
        super();
    }

    public ExamNotFoundException(String message) {
        super(message);
    }
}
