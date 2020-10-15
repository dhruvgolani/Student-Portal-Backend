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

    public ResponseModel(){

    }

    public ResponseModel(Boolean success, String errorCode, String error, Map<Object, Object> data) {
        this.success = success;
        this.errorCode = errorCode;
        this.error = error;
        this.data = data;
    }
}
