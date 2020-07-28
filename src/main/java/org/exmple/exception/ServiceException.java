package org.exmple.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Throwable throwable){
        super(message,throwable);
    }

    public ServiceException(Throwable throwable){
        super(throwable);
    }
}
