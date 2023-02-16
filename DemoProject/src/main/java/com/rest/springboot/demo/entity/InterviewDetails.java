package com.rest.springboot.demo.entity;

import java.util.Date;

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
@Table(name="INTERVIEW_DETAILS")
public class InterviewDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INTERVIEW_DETAILS_ID")
	private int interviewDetailsId;
	
	@Column(name="INTERVIEW_DATE")
	private Date interviewDate;
	
	@Column(name="INTERVIEW_TIME")
	private String interviewTime;
	
}
