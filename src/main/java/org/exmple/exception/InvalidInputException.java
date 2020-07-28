package org.exmple.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message){
        super(message);
    }

    public InvalidInputException(String message, Throwable throwable){
        super(message,throwable);
    }

    public InvalidInputException(Throwable throwable){
        super(throwable);
    }
}
