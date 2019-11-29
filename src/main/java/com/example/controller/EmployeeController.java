package com.example.controller;


import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Employee;
import com.example.entity.Job;
import com.example.service.EmployeeService;
import com.example.service.JobRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	private JobRepository jobsService;
	
	
	@Autowired
	public EmployeeController(EmployeeService employeServ,JobRepository jobsServ) {
		this.employeeService=employeServ;
		this.jobsService=jobsServ;
	}
	
	
	
	@RequestMapping("/employees")
	public List<Employee> getEmployee() {
		return employeeService.findAll();
		 
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		return employeeService.findById(id).get();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		employeeService.findById(id);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteById(id);
	}
	
	
	@RequestMapping("/employees/job")
	public List<Job> getJobs() {
		return  jobsService.findAll();
	}
	
	
	//REquest BOdy STring description was working
	@RequestMapping(method=RequestMethod.POST, value="/employees/job")
	public void addJob(@RequestBody Job job) {
		job.setStartDateTime();
		jobsService.save(job);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/job/{id}")
	public void deleteJob(@PathVariable int id) {
		jobsService.deleteById(id);
	}
	
	
	
 	

}
	

	
	
	
	
	
	
	
	/*
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Request request) {
		Job job = jobsService.findById(request.getJobId()).get();
		Employee employe = new Employee();
		employe.setName(request.getName());
		employe.setSalary(request.getSalary());
		employe.setJobId(job);
		return employeeService.save(employe);
	}
	
	*/
	

