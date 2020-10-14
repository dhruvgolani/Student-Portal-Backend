package com.studentportalbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseModel {
    private Boolean success;
    private String errorCode;
    private String error;
    private Map<Object, Object> data;
}
