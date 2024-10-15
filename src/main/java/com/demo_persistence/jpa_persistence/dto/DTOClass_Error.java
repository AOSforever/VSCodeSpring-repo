package com.demo_persistence.jpa_persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DTOClass_Error {
    private String code;
    private String msg;
}
