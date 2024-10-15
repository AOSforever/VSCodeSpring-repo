package com.demo_persistence.jpa_persistence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_persistence.jpa_persistence.controllers.advice.TeacherNotfoundException;
import com.demo_persistence.jpa_persistence.dto.DTOClass_Teacher;
import com.demo_persistence.jpa_persistence.dto.DTOClass_UpdateTeacher;
import com.demo_persistence.jpa_persistence.models.ModelTeacher;
import com.demo_persistence.jpa_persistence.repository.mapper._RepositoryTeacher;

import lombok.extern.slf4j.Slf4j;

@Service
public class ServiceTeacher {

    @Autowired
    _RepositoryTeacher repository;

    public ServiceTeacher(_RepositoryTeacher repository) {
        this.repository = repository;
    }
    
    public ModelTeacher serv_register_teacher ( ModelTeacher model ) {
        ModelTeacher modelSaved = repository.save( model );
        return modelSaved;
    }

    public void serv_remove_teacher ( Long id ) {
        
        ModelTeacher found = repository.findById(id).orElseThrow( () -> {
            return new TeacherNotfoundException(id);
        } );


        repository.deleteById( id );
    }

    public List<DTOClass_Teacher> serv_listDTO_teacher () {
        
        List<DTOClass_Teacher> listDTOClass_Teacher = repository._repo_list_teacher();
        
        return listDTOClass_Teacher;
    }

    public List<ModelTeacher> serv_list_teacher() {
        
        List<ModelTeacher> listModelTeacher = repository.findAll();


        return listModelTeacher;
    }

    public ModelTeacher serv_search_teacher (Long id) {
        
        ModelTeacher model_found = repository.findById(id).orElseThrow(() -> {
            return new TeacherNotfoundException( id );
        });


        return model_found;
    }

    public ModelTeacher serv_update_teacher( Long id, DTOClass_UpdateTeacher model ) {

        ModelTeacher model_found = repository.findById( id ).orElseThrow( () -> {
            return new TeacherNotfoundException( id );
        });


        model_found.setTeacherName( model.getTeacherName() );
        model_found.setTeacherLastName( model.getTeacherLastName() );
        model_found.setTeacherPhoneNumber( model.getTeacherPhoneNumber() );
        model_found.setTeacherEmail( model.getTeacherEmail() );
        model_found.setTeacherGender( model.getTeacherGender() );

        return repository.save(model_found);
    }
}
