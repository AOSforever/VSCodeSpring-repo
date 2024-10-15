package com.demo_persistence.jpa_persistence.controllers.advice;

public class TeacherForbiddenException extends RuntimeException {
    public TeacherForbiddenException(Long id) {
        super("Could not delete entity Teacher with code " + id + " because it's not allowed");
    }
}
