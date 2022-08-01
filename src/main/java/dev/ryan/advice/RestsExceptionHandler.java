package dev.ryan.advice;

import dev.ryan.exceptions.ErrorResponse;
import dev.ryan.exceptions.ImmutableExpenseException;
import dev.ryan.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestsExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND)
    public ErrorResponse unKnownException(Exception ex) {
        return new ErrorResponse(404, "Resource not found");
    }

    @ExceptionHandler(ImmutableExpenseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(Exception ex) {
        return new ErrorResponse(400, "Expenses that have already been approved or denied " +
                "can not be changed or deleted.");
    }
}