package com.demo_persistence.jpa_persistence.controllers.advice;

public class TeacherNotfoundException extends RuntimeException {
    public TeacherNotfoundException(Long id) {
        super("Could not find the resource with code " + id + ". Try again with other code");
    }
}
