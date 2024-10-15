package com.demo_persistence.jpa_persistence.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(
    name = "TEACHER",
    schema = "SQ_ADMIN",
    uniqueConstraints = @UniqueConstraint(columnNames = "teacherPhoneNumber"),
    indexes = {
        @Index(
            name = "IDX_VAL_NAME", 
            columnList = "teacherName, teacherLastName",
            unique = true
        )
    }
)

@JsonAutoDetect(fieldVisibility = Visibility.NONE)
public class ModelTeacher {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )

    private Long idTeacher;

    @NotBlank
    @Size( max = 40, min = 5, message = "El nombre del profesor debe tener entre 5 y 40 caracteres." )
    @Column( length = 40 )
    private String teacherName;

    @NotBlank
    @Size( max = 50, min = 10, message = "El apellido del profesor debe tener entre 10 y 50 caracteres." )
    @Column( length = 50 )
    private String teacherLastName = "Unknown";

    @Column( length = 9 )
    @Pattern( regexp = "^(\\+\\d{2,3}|00\\d{2}|\\d{2})?[ -]*(\\d)[ -]*([0-9][ -]*){6,8}$" )
    private String teacherPhoneNumber;

    @Positive
    @Min(20)
    @Column( nullable = false )
    private int teacherAge;

    @Email
    @Column( length = 50 )
    private String teacherEmail;

    @Temporal( TemporalType.DATE )
    @Column( nullable = false )
    private Date entryDate;

    
    public enum TeacherGender {
        Male, Female
    }
    
    @NotNull
    @Enumerated( EnumType.STRING )
    private TeacherGender teacherGender;

    // MI ENTIDAD LLAMADA 'TEACHER'
    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable( // DEFINIMOS LA INTERMEDIARÍA
        name = "TEACHER_COURSE", // NOMBRE DE LA INTERMEDIARIA
        schema = "SQ_ADMIN", // NOMBRE DEL ESQUEMA (EN MI CASO)
        joinColumns = @JoinColumn( name = "idTeacher"), // DEFINE EL @ID DE LA FK DE ESTA ENTIDAD
        inverseJoinColumns = @JoinColumn( name= "idCourse" ) // DEFINE EL @ID DE LA FK DE LA OTRA ENTIDAD
    )
    private List<ModelCourse> ls_courses;
};


// Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near '' at line 3

