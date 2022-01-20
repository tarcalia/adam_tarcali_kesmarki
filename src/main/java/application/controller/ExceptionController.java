package application.controller;

import application.service.InputService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController{
    UserController userController;
    InputService inputService;

    public ExceptionController(UserController userController, InputService inputService) {
        this.userController = userController;
        this.inputService = inputService;
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleUncaughtException(Exception ex) {
        String message = "Something bad happened";

        return null;
    }
}
