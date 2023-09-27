package com.mjc.school.service.validation;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String message){
        super(message);
    }
}