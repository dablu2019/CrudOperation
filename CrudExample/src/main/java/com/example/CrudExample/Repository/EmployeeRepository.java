package com.example.CrudExample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudExample.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	
	// all crud database method

}
