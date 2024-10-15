package com.demo_persistence.jpa_persistence.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo_persistence.jpa_persistence.controllers.advice.TeacherForbiddenException;
import com.demo_persistence.jpa_persistence.controllers.advice.TeacherNotfoundException;
import com.demo_persistence.jpa_persistence.dto.DTOClass_Error;



@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DTOClass_Error> runtimeException( RuntimeException exception ) {
        DTOClass_Error obj_error = DTOClass_Error.builder().code("P-500").msg( exception.getMessage() ).build();
        return new ResponseEntity<>(obj_error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeacherForbiddenException.class)
    public ResponseEntity<DTOClass_Error> teacherForbidden( TeacherForbiddenException ex ) {
        DTOClass_Error obj_error = DTOClass_Error.builder().code("P-403").msg( ex.getMessage() ).build();
        return new ResponseEntity<>(obj_error,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(TeacherNotfoundException.class)
    public ResponseEntity<DTOClass_Error> teacherNotFound( TeacherNotfoundException ex ) {
        DTOClass_Error obj_error = DTOClass_Error.builder().code("P-404").msg( ex.getMessage() ).build();
        return new ResponseEntity<>( obj_error, HttpStatus.NOT_FOUND );
    }  
}
