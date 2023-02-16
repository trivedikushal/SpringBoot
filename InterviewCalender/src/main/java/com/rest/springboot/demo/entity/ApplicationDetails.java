package com.rest.springboot.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="APPLICATION_DETAILS")
public class ApplicationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLICATION_DETAILS_ID")
	private int applicationDetailsId;
	
	@OneToOne(targetEntity = CompanyDetails.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "COMPANY_DETAILS_ID")
	private CompanyDetails companyDetails;
	
	@Column(name = "POSITION_ID")
	private String positionName;
	
	@OneToOne(targetEntity = DeliveryType.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_TYPE_ID")
	private DeliveryType deliveryType;
	
	@OneToOne(targetEntity = JobType.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_TYPE_ID")
	private JobType jobType;
	
	@Column(name = "APPLICATION_STATUS")
	private String applicationStatus;
	
	@Column(name = "APPLICATION_PLATFORM")
	private String applicationPlatform;
	
	@Column(name = "APPLIED_DATE")
	private Date appliedDate;
	
	@OneToOne(targetEntity = InterviewDetails.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "INTERVIEW_DETAILS_ID")
	private InterviewDetails interviewDetails;
	
}
