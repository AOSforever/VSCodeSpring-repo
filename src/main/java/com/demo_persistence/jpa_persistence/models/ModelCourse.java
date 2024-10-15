package com.demo_persistence.jpa_persistence.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( 
    name = "COURSE",  
    schema = "SQ_ADMIN"
)
@JsonInclude( JsonInclude.Include.NON_NULL )
public class ModelCourse {
    @Id
    @Column( name = "idCourse", length = 5 )
    @JsonProperty("code")
    private String idCourse;

    @Column( name = "courseName" )
    private String courseName;

    @ManyToMany(mappedBy = "ls_courses")
    @JsonIgnore
    private List<ModelStudent> ls_students;

    // MI ENTIDAD LLAMADA 'COURSES'
    @ManyToMany(mappedBy = "ls_courses", fetch = FetchType.LAZY)
    // 'mappedBy' indica quien controla la relacion (Quien tiene la intermediaria)
    @JsonIgnore
    private List<ModelTeacher> ls_teachers;
}
