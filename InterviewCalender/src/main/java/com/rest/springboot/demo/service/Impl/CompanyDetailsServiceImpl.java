package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.City;
import com.rest.springboot.demo.entity.CompanyDetails;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.CompanyDetailsRepository;
import com.rest.springboot.demo.service.CompanyDetailsService;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService{

	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;
	
	@Override
	public CompanyDetails createCompanyDetails(CompanyDetails companyDetailsObj) {
		return companyDetailsRepository.save(companyDetailsObj);
	}

	@Override
	public List<CompanyDetails> getAllCompanyDetails() {
		return companyDetailsRepository.findAll();
	}

	@Override
	public CompanyDetails updateCompanyDetails(int companyDetailsId, CompanyDetails companyDetailsObj) {
		CompanyDetails existingObj= companyDetailsRepository.findById(companyDetailsId).orElseThrow(()-> new ResourceNotFoundException("COMPANY_DETAILS", "COMPANY_DETAILS_ID", companyDetailsId));
		existingObj.setCity(companyDetailsObj.getCity());
		existingObj.setCompanySize(companyDetailsObj.getCompanySize());
		existingObj.setPositionId(companyDetailsObj.getPositionId());
		return companyDetailsRepository.save(existingObj);
	}

	@Override
	public CompanyDetails getCompanyDetailsById(int companyDetailsId) {
		return companyDetailsRepository.findById(companyDetailsId).orElseThrow(()-> new ResourceNotFoundException("COMPANY_DETAILS", "COMPANY_DETAILS_ID", companyDetailsId));
	}

	@Override
	public void deleteCompanyDetails(int companyDetailsId) {
		companyDetailsRepository.findById(companyDetailsId).orElseThrow(()-> new ResourceNotFoundException("COMPANY_DETAILS", "COMPANY_DETAILS_ID", companyDetailsId));
		companyDetailsRepository.deleteById(companyDetailsId);
	}

}
