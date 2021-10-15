package com.example.demo.controller.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("add-employee")
public class AddEmployeeController {
    @GetMapping
    public String addEmployeePage(){ return "add-employee"; }
}
