package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	public List<Job> findAll();
			

}
