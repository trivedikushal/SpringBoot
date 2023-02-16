package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.CompanyDetails;

public interface CompanyDetailsService {
	
	public CompanyDetails createCompanyDetails(CompanyDetails companyDetailsObj);
	
	public List<CompanyDetails> getAllCompanyDetails();
	
	public CompanyDetails updateCompanyDetails(int companyDetailsId,CompanyDetails companyDetailsObj);
	
	public CompanyDetails getCompanyDetailsById(int companyDetailsId);
	
	public void deleteCompanyDetails(int companyDetailsId);

}
