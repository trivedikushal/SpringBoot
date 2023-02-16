package com.rest.springboot.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="COMPANY_DETAILS")
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COMPANY_DETAILS_ID")
	private int companyDetailsId;
	
	@Column(name="COMPANY_SIZE")
	private int companySize;
	
	@OneToOne(targetEntity = City.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	private City city;
	
	@Column(name="POSITION_ID")
	private String positionId;
	
}
