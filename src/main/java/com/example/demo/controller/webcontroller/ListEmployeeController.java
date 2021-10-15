package com.example.demo.controller.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class ListEmployeeController {
    @GetMapping
    public String employeePage(){return "employee"; }
}
