package org.exmple.advice;

import org.exmple.exception.InvalidInputException;
import org.exmple.exception.UnauthorizedException;
import org.exmple.exception.ServiceException;
import org.exmple.exception.NotFoundException;
import org.exmple.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiError handleUnauthorizedException(UnauthorizedException unauthorizedException){
        return ApiError.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .error(unauthorizedException.getLocalizedMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiError handleNotFoundException(NotFoundException notFoundException){
        return ApiError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error(notFoundException.getLocalizedMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiError handleUserException(ServiceException serviceException){
        return ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(serviceException.getLocalizedMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleInvalidInputException(InvalidInputException invalidInputException){
        return ApiError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(invalidInputException.getLocalizedMessage())
                .build();
    }

}
