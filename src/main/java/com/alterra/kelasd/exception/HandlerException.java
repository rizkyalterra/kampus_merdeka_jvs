package com.alterra.kelasd.exception;

import com.alterra.kelasd.controller.base.MBaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MBaseResponse BadRequestException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        return new MBaseResponse<>(false, defaultMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public MBaseResponse<?> handleExceptionError(Exception ex) {
        String message = ex.getMessage();
        MBaseResponse<?> response = new MBaseResponse<>(false, message);
        return response;
    }

}
