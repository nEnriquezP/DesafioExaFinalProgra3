package edu.projectp.controllers;

import edu.projectp.exceptions.NotFoundException;
import edu.projectp.models.pojos.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Message notFountException(NotFoundException e){
        Message message = new Message();
        message.setSubject(e.getMessage());
        message.setDatetime(LocalDateTime.now().format(formatter));
        return message;
    }

    //Maneja los errores de @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Message> methodArgumentNotValidException(MethodArgumentNotValidException e){
        List<Message> messages = new ArrayList<>();
        e.getAllErrors().forEach(error -> {
            Message message = new Message();
            message.setSubject(error.getDefaultMessage());
            message.setDatetime(LocalDateTime.now().format(formatter));
            messages.add(message);
        });
        return messages;
    }
}
