package com.demo_persistence.jpa_persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOClass_Course {
    private String idCourse;
    private String courseName;
}
