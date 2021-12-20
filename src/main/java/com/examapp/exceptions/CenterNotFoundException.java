package com.examapp.exceptions;

public class CenterNotFoundException extends RuntimeException{

    public CenterNotFoundException() {

        super();
    }

    public CenterNotFoundException(String message) {
        super(message);
    }

}
