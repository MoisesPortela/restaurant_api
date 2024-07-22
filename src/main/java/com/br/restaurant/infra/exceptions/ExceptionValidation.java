package com.br.restaurant.infra.exceptions;

public class ExceptionValidation extends RuntimeException {
    public ExceptionValidation(String message){
        super(message);
    }
}
