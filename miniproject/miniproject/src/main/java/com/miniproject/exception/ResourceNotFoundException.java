package com.miniproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourcesName;//This is like Post
    private String fieldName;//Not found with this id
    private long fieldValue;//This is like id

    public ResourceNotFoundException(String resourcesName, String fieldName, long fieldValue) {
        super(String.format("%S not found with %S:'%S'",resourcesName,fieldName,fieldValue));
        this.resourcesName = resourcesName;
        this.fieldName = fieldName;
        this.fieldValue=fieldValue;
    }

    public ResourceNotFoundException(HttpStatus badRequest, String s) {
    }

    public String getResourcesName() {

        return resourcesName;
    }

    public String getFieldName() {

        return fieldName;
    }

    public long getFieldValue() {

        return fieldValue;
    }
}
