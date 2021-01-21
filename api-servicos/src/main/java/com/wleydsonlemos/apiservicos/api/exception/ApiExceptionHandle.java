package com.wleydsonlemos.apiservicos.api.exception;

import com.wleydsonlemos.apiservicos.api.model.exception.FieldsError;
import com.wleydsonlemos.apiservicos.api.model.exception.ResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandle extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldsError> fieldsError = new ArrayList<>();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> fieldsError.add(new FieldsError(((FieldError)error).getField(), error.getDefaultMessage())));

        ResponseError error = ResponseError.builder()
                .status(status.value())
                .error("Um ou mais campos estão inválidos")
                .dateTime(OffsetDateTime.now())
                .fieldsError(fieldsError)
                .build();

        return super.handleExceptionInternal(ex, error, headers, status, request);
    }
}
