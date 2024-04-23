package com.link.generator.system.link.generator.system.exception;


import com.link.generator.system.link.generator.system.utils.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvoiceAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleDealRequestAlreadyExist(InvoiceAlreadyExistException xe){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(409, xe.getMessage(), new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException xe){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(409, xe.getMessage() , new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidInvoiceException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDealRequest(InvalidInvoiceException xe){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(400, xe.getMessage() , new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneralException(Exception xe){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(500, "An error has occurred on the server" , new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handlePersonAlreadyExist(IllegalArgumentException xe){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(400, xe.getMessage() , new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException xe){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(400, xe.getMessage() , new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
    
}
