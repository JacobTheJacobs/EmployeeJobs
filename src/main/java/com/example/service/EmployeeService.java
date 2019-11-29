package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Employee;

public interface EmployeeService extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByName(String name);
	
	Employee findByJobId(int id);

}
