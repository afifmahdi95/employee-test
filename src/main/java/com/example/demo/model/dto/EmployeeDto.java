package com.example.demo.model.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class EmployeeDto {
    private BigInteger id;
    private String name;
    private BigInteger salary;
    private Integer grade;
}
