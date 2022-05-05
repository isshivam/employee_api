package com.knoldus.employee_api.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorObject {
    private Integer statusCode;
    private String message;
}
