package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.ApplicationDetails;
import com.rest.springboot.demo.entity.Company;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.CompanyRepository;
import com.rest.springboot.demo.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company createCompany(Company companyObj) {
		return companyRepository.save(companyObj);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company updateCompany(int companyId, Company companyObj) {
		Company existingObj= companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("COMPANY", "COMPANY_ID", companyId));
		existingObj.setCompanyName(companyObj.getCompanyName());
		return companyRepository.save(existingObj);
	}

	@Override
	public Company getCompanyById(int companyId) {
		return companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("COMPANY", "COMPANY_ID", companyId));
	}

	@Override
	public void deleteCompany(int companyId) {
		companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("COMPANY", "COMPANY_ID", companyId));
		companyRepository.deleteById(companyId);
	}

}
