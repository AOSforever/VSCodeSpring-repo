package com.demo_persistence.jpa_persistence.repository.mapper;

import java.util.List;
import com.demo_persistence.jpa_persistence.models.ModelStudent;

public interface _RepositoryCustom {
    public ModelStudent _repo_create_student(ModelStudent object);
    public void _repo_remove_student(Long id);
    public ModelStudent _repo_update_student(Long id, ModelStudent object);
    public ModelStudent _repo_search_student(Long id);
    public List<ModelStudent> _repo_list_student();
}
