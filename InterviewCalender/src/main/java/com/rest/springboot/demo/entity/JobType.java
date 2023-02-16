package com.rest.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="JOB_TYPE")
public class JobType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_TYPE_ID")
	private int jobTypeId;
	
	@Column(name = "JOB_TYPE_NAME")
	private String jobTypeName;
}
