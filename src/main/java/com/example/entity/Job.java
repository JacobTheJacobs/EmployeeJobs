package com.example.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.JobRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="enddate")
	private Date endDate;
	
	@Column(name="startdatetime")
	private Date startDateTime;
	
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public void setStartDateTime() {
		LocalDate date = LocalDate.now();
		java.sql.Date dateNew = java.sql.Date.valueOf(date);
		///System.out.println(dateNew);
		this.startDateTime = dateNew;
	}

	public Date getStartDateTime() {
	    return startDateTime;
	}	
}
