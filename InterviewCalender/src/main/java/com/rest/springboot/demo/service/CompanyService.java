package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.Company;

public interface CompanyService {
	
	public Company createCompany(Company companyObj);
	
	public List<Company> getAllCompanies();
	
	public Company updateCompany(int companyId,Company companyObj);
	
	public Company getCompanyById(int companyId);
	
	public void deleteCompany(int companyId);

}
