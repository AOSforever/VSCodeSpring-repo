package com.demo_persistence.jpa_persistence.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo_persistence.jpa_persistence.dto.DTOClass_Course;
import com.demo_persistence.jpa_persistence.models.ModelCourse;

@Repository
public interface _RepositoryCourse extends JpaRepository<ModelCourse,String>{

    @Query("""
        SELECT new com.demo_persistence.jpa_persistence.dto.DTOClass_Course( model.idCourse, model.courseName ) FROM ModelCourse model   
        """)
    public List<DTOClass_Course> _repo_list_course();
}
