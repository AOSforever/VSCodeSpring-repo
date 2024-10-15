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
@Slf4j
public class ServiceTeacher {

    @Autowired
    _RepositoryTeacher repository;

    public ServiceTeacher(_RepositoryTeacher repository) {
        this.repository = repository;
    }
    
    public ModelTeacher serv_register_teacher ( ModelTeacher model ) {
        log.info("Iniciando el metodo con retorno 'serv_register_teacher()' en el servicio 'ServiceTeacher' para registrar un modelo de tipo 'ModelTeacher'");

        ModelTeacher modelSaved = repository.save( model );

        log.info("'ModelTeacher' registrado exitosamente: : '{}'",model);

        log.info("Retornando modelo registrado");

        return modelSaved;
    }

    public void serv_remove_teacher ( Long id ) {
        log.info("Iniciando el metodo sin retorno 'serv_remove_teacher()' en el servicio 'ServiceTeacher' para eliminar un modelo con ID : '{}'.",id);
        
        ModelTeacher found = repository.findById(id).orElseThrow( () -> {
            log.error("No se encontró el ModelTeacher con ID: '{}'. Lanzando excepcion.",id);
            return new TeacherNotfoundException(id);
        } );

        log.info("ModeloTeacher encontrado : '{}'",found);

        repository.deleteById( id );
        log.info("ModelTeacher con ID: '{}', eliminado exitosamente.",id);
    }

    public List<DTOClass_Teacher> serv_listDTO_teacher () {
        log.info("Iniciando el metodo con retorno 'serv_listDTO_teacher()' en el servicio 'ServiceTeacher' para listar modelos DTOs de tipo 'DTOClass_Teacher'.");
        
        List<DTOClass_Teacher> listDTOClass_Teacher = repository._repo_list_teacher();
        
        log.info("Lista de modelos tipo 'DTOClass_Teacher' obtenido con longitud de : '{}'.", listDTOClass_Teacher.size());

        return listDTOClass_Teacher;
    }

    public List<ModelTeacher> serv_list_teacher() {
        log.info("Iniciando el metodo con retorno 'serv_list_teacher()' en el servicio 'ServiceTeacher' para lista modelos de tipo 'ModelTeacher'.");
        
        List<ModelTeacher> listModelTeacher = repository.findAll();

        log.info("Lista de modelos de tipo 'ModelTeacher' obtenido con longitud de : '{}'.", listModelTeacher.size());

        return listModelTeacher;
    }

    public ModelTeacher serv_search_teacher (Long id) {
        log.info("Iniciando el metodo con retorno 'serv_search_teacher()' en el servicio 'ServiceTeacher' para buscar un modelo de tipo 'ModelTeacher' con ID : '{}'.", id);
        
        ModelTeacher model_found = repository.findById(id).orElseThrow(() -> {
            log.error("No se encontró el modelo con ID : '{}'. Lanzando excepcion.", id);
            return new TeacherNotfoundException( id );
        });

        log.info("'ModelTeacher' encontrado : '{}'.", model_found );

        return model_found;
    }

    public ModelTeacher serv_update_teacher( Long id, DTOClass_UpdateTeacher model ) {
        log.info("Iniciando el metodo con retorno 'serv_update_teacher()' en el servicio 'ServiceTeacher' para actualizar un modelo de tipo 'ModelTeacher' con ID : '{}'.", id);

        ModelTeacher model_found = repository.findById( id ).orElseThrow( () -> {
            log.error("No se encontró el modelo con ID : '{}'. Lanzando excepcion.", id);
            return new TeacherNotfoundException( id );
        });

        log.info("'ModelTeacher' encontrado : '{}'.", model_found );

        model_found.setTeacherName( model.getTeacherName() );
        model_found.setTeacherLastName( model.getTeacherLastName() );
        model_found.setTeacherPhoneNumber( model.getTeacherPhoneNumber() );
        model_found.setTeacherEmail( model.getTeacherEmail() );
        model_found.setTeacherGender( model.getTeacherGender() );

        log.info("'ModeloTeacher' actualizado : '{}'", model_found);

        return repository.save(model_found);
    }
}
