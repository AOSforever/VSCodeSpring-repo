package com.demo_persistence.jpa_persistence.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.demo_persistence.jpa_persistence.controllers.advice.TeacherForbiddenException;
import com.demo_persistence.jpa_persistence.dto.DTOClass_Teacher;
import com.demo_persistence.jpa_persistence.dto.DTOClass_UpdateTeacher;
import com.demo_persistence.jpa_persistence.models.ModelTeacher;
import com.demo_persistence.jpa_persistence.services.ServiceTeacher;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/teacher")
public class ControllerTeacher {

    @Autowired
    private ServiceTeacher service;

    @PutMapping("/update/{id}")
    public ResponseEntity<String> mtc_update_teacher(@PathVariable Long id, @Valid @RequestBody DTOClass_UpdateTeacher model) {

        service.serv_update_teacher(id, model);

        ResponseEntity<String> response = ResponseEntity.ok()
        .header("Location", "/teacher/list").body("Actualizado correctamente");

        return response;
    }

    @GetMapping("/listDTO")
    public List<DTOClass_Teacher> mtc_listDTO_teacher() {
        return service.serv_listDTO_teacher();
    }

    @GetMapping("/list")
    public List<ModelTeacher> mtc_list_teacher() {
        return service.serv_list_teacher();
    }

    @PostMapping("/register")
    public ResponseEntity<String> mtc_create_teacher(@RequestBody ModelTeacher model) {

        service.serv_register_teacher(model);
        
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CREATED)
        .header("Location", "/teacher/register").body("Creado exitosamente");
        
        return response;
    }

    @GetMapping("/search/{id}")
    public ModelTeacher mtc_find_teacher(@PathVariable Long id) {
        return service.serv_search_teacher(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> mtc_delete_teacher(@PathVariable Long id) {

        service.serv_remove_teacher(id);

        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
        .header("Location", "/delete/" + id).body("Eliminado exitosamente");

        // throw new TeacherForbidden( (long) id );

        return response;
    }
}
