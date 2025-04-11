package com.bs24.demo.common.error;

import com.bs24.demo.common.exception.ResourceAlreadyExistsException;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceNotFoundException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(ResourceNotFoundException exception) {
        log.error(exception.getMessage());
        return new ErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            ResourceAlreadyExistsException.class
    })
    @ResponseBody
    public ErrorMessage resourceAlreadyExists(ResourceAlreadyExistsException exception) {
        log.error(exception.getMessage());
        return new ErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    @ResponseBody
    public ErrorMessage validationException(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage());
        return new ErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleGeneralException(Exception exception) {
        log.error(exception.getMessage());
        return new ErrorMessage(new RuntimeException("Internal error"));
    }
}

