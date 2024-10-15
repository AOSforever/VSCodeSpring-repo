package com.demo_persistence.jpa_persistence.models;

import java.util.List;

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
    name = "STUDENT", 
    schema = "SQ_STUDENT", 
    uniqueConstraints = @UniqueConstraint(columnNames = "studentDNI")
)

public class ModelStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent")
    private Long idStudent;

    @Column(
        name = "studentName", 
        length = 40, 
        nullable = false
    )
    private String studentName;

    @Column(
        name = "studentLastName", 
        length = 50, 
        nullable = false
    )
    private String studentLastName;

    @Column(name = "studentAge")
    private int studentAge;

    @Column(
        name = "studentDNI", 
        length = 8, 
        nullable = false, 
        unique = true
    )
    private String studentDNI;

    @ManyToMany
    @JoinTable(
        name = "STUDENT_COURSE",
        schema = "SQ_STUDENT",
        joinColumns = @JoinColumn( name = "idStudent" ),
        inverseJoinColumns = @JoinColumn( name = "idCourse" )
    )
    private List<ModelCourse> ls_courses;

}