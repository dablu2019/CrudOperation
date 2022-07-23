package com.example.CrudExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.CrudExample.Model.Employee;
import com.example.CrudExample.Repository.EmployeeRepository;

@SpringBootApplication
public class CrudExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudExampleApplication.class, args);
		
	}
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setFirstName("Rajan");
		emp.setLastName("kumar");
		emp.setEmailId("rajan123@gmail.com");
		employeeRepository.save(emp);
		Employee emp1=new Employee();
		emp1.setFirstName("chandan");
		emp1.setLastName("sah");
		emp1.setEmailId("ck123@gmail.com");
		employeeRepository.save(emp1);
		
		
	}

}
