package com.example.demo.controller;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ApiController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.ok().body(employeeService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveData(@RequestBody EmployeeDto employeeDto) {
        try {
            return ResponseEntity.ok().body(employeeService.insertData(employeeDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody EmployeeDto employeeDto) {
        try {
            return ResponseEntity.ok().body(employeeService.updateData(employeeDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
