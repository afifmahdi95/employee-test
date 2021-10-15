package com.example.demo.interfaces;

import com.example.demo.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
    @Query(value = "SELECT EMPLOYEE.ID AS ID," +
            " EMPLOYEE.NAME AS NAME," +
            " EMPLOYEE.SALARY AS SALARY," +
            " CAST(EMPLOYEE.GRADE AS VARCHAR) || ' : ' || GRADE_REF.NAME AS GRADE," +
            " EMPLOYEE.SALARY + (SALARY * 0.1) AS BONUS" +
            " FROM EMPLOYEE " +
            "JOIN GRADE_REF ON GRADE_REF.ID = EMPLOYEE.GRADE", nativeQuery = true)
    List<Map<String, Object>> getDataAll();

}
