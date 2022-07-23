package com.example.CrudExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudExample.Exception.ResourceNotFoundException;
import com.example.CrudExample.Model.Employee;
import com.example.CrudExample.Repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}

	
	//create employee Restapi
	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeRepository.save(emp);
	}
	//get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		return ResponseEntity.ok(emp);
		
	}
	//update employee rest api
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(long id,Employee employeeDetails){
		Employee updateEmployee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("emplyee not exist id:"+id));
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
	}
	
}



