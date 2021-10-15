package com.example.demo;

import com.example.demo.controller.ApiController;
import com.example.demo.model.MessageModel;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entity.Employee;
import com.example.demo.services.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class DemoApplicationTests {

	@Autowired
	ApiController apiController;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsert(){
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setName("Syauki");
		employeeDto.setGrade(3);
		employeeDto.setSalary(BigInteger.valueOf(1000000));

		ResponseEntity<?> insertData = apiController.saveData(employeeDto);

		Assert.assertEquals("Insert Data", ResponseEntity.ok().body(new MessageModel(){{
			setStatus(HttpStatus.OK.toString());
			setMessage("Success");
			setData(new Employee(){{
				setId(BigInteger.valueOf(10006));
				setName("Syauki");
				setSalary(BigInteger.valueOf(1000000));
				setGrade(3);
			}});
		}}), insertData);

		MessageModel obj = (MessageModel) insertData.getBody();
		Assert.assertNotNull("Check object response not null", obj);
		Employee emp = (Employee) obj.getData();
		Assert.assertNotNull("Check object employee not null", emp);
		BigInteger id = emp.getId();

		Assert.assertNotNull("Check ID after insert", id);

		Assert.assertEquals("Check data after insert", ResponseEntity.ok().body(new MessageModel(){{
			setStatus(HttpStatus.OK.toString());
			setMessage("Success");
			setData(new Employee(){{
				setId(BigInteger.valueOf(10006));
				setName("Syauki");
				setSalary(BigInteger.valueOf(1000000));
				setGrade(3);
			}});
		}}), apiController.getById(id));
	}


}
