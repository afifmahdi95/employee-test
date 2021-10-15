package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {
    public static final String TABLE_NAME = "EMPLOYEE";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = TABLE_NAME)
    @TableGenerator(name = TABLE_NAME, table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = TABLE_NAME, valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 10000)
    @Column(name = "id", length = 11)
    private BigInteger id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "salary")
    private BigInteger salary;

    @Column(name = "grade", length = 1)
    private Integer grade;



}
