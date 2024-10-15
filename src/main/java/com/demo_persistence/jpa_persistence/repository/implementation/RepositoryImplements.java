package com.demo_persistence.jpa_persistence.repository.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo_persistence.jpa_persistence.models.ModelStudent;
import com.demo_persistence.jpa_persistence.repository.mapper._RepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class RepositoryImplements implements _RepositoryCustom {

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public ModelStudent _repo_create_student(ModelStudent object) {
        manager.persist(object);
        return object;
    }

    @Override
    @Transactional
    public void _repo_remove_student(Long id) {
        ModelStudent objStudent = manager.find(ModelStudent.class, id);

        if(objStudent != null) manager.remove(objStudent);
        else
            return;
    }

    @Override
    @Transactional
    public ModelStudent _repo_update_student(Long id, ModelStudent object) {
        ModelStudent objStudent = manager.find(ModelStudent.class, id);

        if(objStudent != null) {
            objStudent.setStudentAge(object.getStudentAge());
            objStudent.setStudentDNI(object.getStudentDNI());
            objStudent.setStudentLastName(object.getStudentLastName());
            objStudent.setStudentName(object.getStudentName());
        } else 
            return null;

        return manager.merge(objStudent);
    }

    @Override
    @Transactional
    public ModelStudent _repo_search_student(Long id) { /**/ return manager.find(ModelStudent.class, id); /**/ }

    @Override
    @Transactional
    public List<ModelStudent> _repo_list_student() { /**/ return manager.createQuery("SELECT entity FROM ModelStudent entity",ModelStudent.class).getResultList(); /**/ }
}
