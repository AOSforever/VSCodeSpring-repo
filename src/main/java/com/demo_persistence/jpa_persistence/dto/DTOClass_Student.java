package com.demo_persistence.jpa_persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
// @ToString(onlyExplicitlyIncluded = true) -> se utiliza @ToString.Include en los atributos para indicar lo que debe incluir en la depuración
@ToString(  includeFieldNames = true, callSuper = true)
public class DTOClass_Student {

    @ToString.Include(name = "Nombre Estudiante", rank = 2)
    private String studentName;
    
    @ToString.Include(name = "Apellido Estudiante")
    private String studentLastName;

    @ToString.Exclude 
    private int studentAge;

    private String studentDNI;
}
