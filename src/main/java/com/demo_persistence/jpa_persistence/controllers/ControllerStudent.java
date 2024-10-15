package com.demo_persistence.jpa_persistence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo_persistence.jpa_persistence.dto.DTOClass_Student;
import com.demo_persistence.jpa_persistence.models.ModelStudent;
import com.demo_persistence.jpa_persistence.services.ServiceStudent;

import lombok.extern.log4j.Log4j2;
// import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




// API REST (RESTFUL)
@RestController
@RequestMapping("/api")
@Log4j2
public class ControllerStudent {
    
    @Autowired
    private ServiceStudent service;

    @PostMapping("/register")
    public ResponseEntity<ModelStudent> mtc_create_student(@RequestBody DTOClass_Student object) {
        ModelStudent objStudent = service.serv_create_student(object);

        ResponseEntity<ModelStudent> response = ResponseEntity.status(HttpStatus.CREATED)
        .header("Location","api/register/" + objStudent.getIdStudent()).body(objStudent);

        return response;
    }

    @GetMapping("/list")
    public List<ModelStudent> mtc_list_student() { 
        log.info("Esto es un log tipo INFO");
        return service.serv_list_student(); 
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ModelStudent> mtc_update_student(@PathVariable Long id, @RequestBody DTOClass_Student object) {
        
        ModelStudent exObj = service.serv_update_student(id, object);

        ResponseEntity<ModelStudent> response = ResponseEntity.ok()
        .header("Location","api/update/" + exObj.getIdStudent() ).body(exObj);

        System.out.println( object );

        return response;
        
    }
    
    @GetMapping("/search/{id}")
    public ModelStudent getMethodName(@PathVariable Long id) {
        return service.serv_search_student(id);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<String> mtc_delete_student(@PathVariable Long id) {
        service.serv_remove_student(id);

        ResponseEntity<String> response = ResponseEntity.ok()
        .header("Location", "api/delete/" + id).body("Eliminado exitosamente");
        return response;
    }
    

}