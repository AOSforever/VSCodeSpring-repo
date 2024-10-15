package com.demo_persistence.jpa_persistence.dto;

import com.demo_persistence.jpa_persistence.models.ModelTeacher.TeacherGender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

// import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// @JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DTOClass_UpdateTeacher {

    @NotBlank
    @Size( max = 40, min = 5, message = "El nombre del profesor debe tener entre 5 y 40 caracteres." )
    private String teacherName;
    
    @NotBlank
    @Size( max = 50, min = 10, message = "El apellido del profesor debe tener entre 10 y 50 caracteres." )
    private String teacherLastName;

    @Pattern( regexp = "^(\\+\\d{2,3}|00\\d{2}|\\d{2})?[ -]*(\\d)[ -]*([0-9][ -]*){6,8}$" )
    private String teacherPhoneNumber;

    @Positive
    @Min(20)
    private int teacherAge;

    @Email
    @Column( length = 50 )
    private String teacherEmail;

    @NotNull
    private TeacherGender teacherGender;
}
