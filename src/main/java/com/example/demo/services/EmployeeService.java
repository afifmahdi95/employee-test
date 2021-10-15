package com.example.demo.services;

import com.example.demo.interfaces.EmployeeRepository;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entity.Employee;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //insert data to table employee
    public Object insertData(EmployeeDto employeeDto){

        //set data from dto to entity
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setGrade(employeeDto.getGrade());

        //do insert
        employeeRepository.save(employee);
        return employee;
    }

    //get all data
    public Object getAll(){
        return employeeRepository.getDataAll();
    }

    //update data to table employee
    public Object updateData(EmployeeDto employeeDto){
        //set data from dto to entity
        Employee employee = (Employee) employeeRepository.findById(employeeDto.getId()).get();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setGrade(employeeDto.getGrade());

        //do insert
        employeeRepository.save(employee);
        return employee;
    }
}
