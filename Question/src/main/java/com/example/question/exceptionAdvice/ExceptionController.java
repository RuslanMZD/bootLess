package com.example.question.exceptionAdvice;


import com.example.question.exception.NotFoundProfileException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// Контроллер Эксепшенов
@ControllerAdvice
public class ExceptionController {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundProfileException.class)
    public String notFoundProfile(NotFoundProfileException ex){
        return ex.getMessage();
    }
}
