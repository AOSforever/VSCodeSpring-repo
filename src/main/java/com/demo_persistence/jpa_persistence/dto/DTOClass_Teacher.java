package com.demo_persistence.jpa_persistence.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

// import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DTOClass_Teacher {

    private String teacherName;

    private String teacherEmail;

    public int teacherAge;

    // Course field
    private String courseName;

}
