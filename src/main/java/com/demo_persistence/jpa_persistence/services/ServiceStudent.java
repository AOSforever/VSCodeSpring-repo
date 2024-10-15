package com.demo_persistence.jpa_persistence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo_persistence.jpa_persistence.dto.DTOClass_Student;
import com.demo_persistence.jpa_persistence.models.ModelStudent;
import com.demo_persistence.jpa_persistence.repository.mapper._RepositoryCustom;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceStudent {

    
    private _RepositoryCustom repository;

    public ServiceStudent(_RepositoryCustom repository) {
        this.repository = repository;
    }

    public ModelStudent serv_create_student(DTOClass_Student object) {

        switch (
            ( object.getStudentDNI().length() != 8  ) ? "DNI" : 
            ( object.getStudentAge() <= 0 ) ? "AGE" : 
            ( object.getStudentLastName().length() == 0 ) ? "LASTNAME" : 
            ( object.getStudentName().length() == 0 )  ? "NAME" : "NONE"
        ) {
            case "DNI":  throw new RuntimeException("DNI debe tener 8 caracteres");     
            case "AGE": throw new RuntimeException("La EDAD debe ser un numero válido");
            case "LASTNAME": throw new RuntimeException("El LASTNAME debe ser válido");
            case "NAME": throw new RuntimeException("El NOMBRE debe ser válido");
            default : break;
        };
        
        ModelStudent objStudent = ModelStudent.builder().studentAge( object.getStudentAge() )
                                              .studentDNI( object.getStudentDNI() )
                                              .studentLastName( object.getStudentLastName() )
                                              .studentName( object.getStudentName() )
                                              .build();
                                              
        return repository._repo_create_student(objStudent);
    }

    public void serv_remove_student(Long id) {
        repository._repo_remove_student(id);
    }

    public ModelStudent serv_update_student(Long id, DTOClass_Student object) {
        
        ModelStudent objStudent = repository._repo_search_student(id);

        if ( objStudent != null ) {
            objStudent.setStudentAge( object.getStudentAge() );
            objStudent.setStudentDNI( object.getStudentDNI() );
            objStudent.setStudentLastName( object.getStudentLastName() );
            objStudent.setStudentName( object.getStudentName() );
        } else throw new RuntimeException("No se encontró al estudiante " + id);

        return repository._repo_update_student(id, objStudent);
    }

    public ModelStudent serv_search_student(Long id) {
        return repository._repo_search_student(id);
    }

    public List<ModelStudent> serv_list_student() {
        log.debug("Este es del servicio");
        return repository._repo_list_student();
    }
    
}
