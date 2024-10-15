package com.demo_persistence.jpa_persistence.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.demo_persistence.jpa_persistence.dto.DTOClass_Course;

import com.demo_persistence.jpa_persistence.services.ServiceCourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/course")
public class ControllerCourse {

    @Autowired
    private ServiceCourse service;

    @GetMapping("/list")
    public List<DTOClass_Course> mtc_list_course() {
        return service.serv_list_course(); 
    }
}
