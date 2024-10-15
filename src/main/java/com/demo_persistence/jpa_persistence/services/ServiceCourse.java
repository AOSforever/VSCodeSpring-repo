package com.demo_persistence.jpa_persistence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_persistence.jpa_persistence.dto.DTOClass_Course;
import com.demo_persistence.jpa_persistence.repository.mapper._RepositoryCourse;

@Service
public class ServiceCourse {

    @Autowired
    private _RepositoryCourse repository;

    public ServiceCourse(_RepositoryCourse repository) {
        this.repository = repository;
    }

    public List<DTOClass_Course> serv_list_course () {
        return repository._repo_list_course();
    }
}
