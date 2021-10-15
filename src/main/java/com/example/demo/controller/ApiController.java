package com.example.demo.controller;

import com.example.demo.model.MessageModel;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/v1")
public class ApiController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        MessageModel msg = new MessageModel();
        try {
            msg.setMessage("Success");
            msg.setStatus(HttpStatus.OK.toString());
            msg.setData(employeeService.getAll());
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            msg.setStatus(HttpStatus.BAD_REQUEST.toString());
            msg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(msg);
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") BigInteger id){
        MessageModel msg = new MessageModel();
        try {
            msg.setStatus(HttpStatus.OK.toString());
            msg.setMessage("Success");
            msg.setData(employeeService.getById(id));
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            msg.setStatus(HttpStatus.BAD_REQUEST.toString());
            msg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(msg);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveData(@RequestBody EmployeeDto employeeDto) {
        MessageModel msg = new MessageModel();
        try {
            Object res = employeeService.insertData(employeeDto);

            msg.setStatus(HttpStatus.OK.toString());
            msg.setMessage("Success");
            msg.setData(res);
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            msg.setStatus(HttpStatus.BAD_REQUEST.toString());
            msg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(msg);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody EmployeeDto employeeDto) {
        MessageModel msg = new MessageModel();
        try {
            msg.setStatus(HttpStatus.OK.toString());
            msg.setMessage("Success");
            msg.setData(employeeService.updateData(employeeDto));
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            msg.setStatus(HttpStatus.BAD_REQUEST.toString());
            msg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(msg);
        }
    }
}
