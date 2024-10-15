package com.demo_persistence.jpa_persistence.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo_persistence.jpa_persistence.dto.DTOClass_Teacher;
import com.demo_persistence.jpa_persistence.models.ModelTeacher;

public interface _RepositoryTeacher extends JpaRepository<ModelTeacher, Long> { 

    @Query(""" 
        SELECT
            new com.demo_persistence.jpa_persistence.dto.DTOClass_Teacher(
                model.teacherName,
                model.teacherEmail,
                model.teacherAge,
                model_course.courseName
            ) 
        FROM ModelTeacher model JOIN model.ls_courses model_course
        """)
    public List<DTOClass_Teacher> _repo_list_teacher();

}
