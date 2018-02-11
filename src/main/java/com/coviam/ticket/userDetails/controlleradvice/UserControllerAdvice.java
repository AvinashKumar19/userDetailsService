package com.coviam.ticket.userDetails.controlleradvice;

import com.coviam.ticket.userDetails.exceptions.RecordNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
//@RequestMapping(produces = "application/vnd.error+json")
public class UserControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<VndErrors> recordNotFound(RecordNotFoundException exception) {
        return error(exception.getUserId(), exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<VndErrors> error(String logref, Exception exception, HttpStatus status) {
        String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return ResponseEntity.status(status).body(new VndErrors(logref, message));
    }
}
