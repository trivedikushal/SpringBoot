package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.ApplicationDetails;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.ApplicationDetailsRepository;
import com.rest.springboot.demo.service.ApplicationDetailsService;

@Service
public class ApplicationDetailsServiceImpl implements ApplicationDetailsService {

	@Autowired
	private ApplicationDetailsRepository applicationDetailsRepository;
	
	@Override
	public ApplicationDetails createApplicationDetails(ApplicationDetails applicationDetailsObj) {
		return applicationDetailsRepository.save(applicationDetailsObj);
	}

	@Override
	public List<ApplicationDetails> getAllApplicationDetails() {
		return applicationDetailsRepository.findAll();
	}

	@Override
	public ApplicationDetails updateApplicationDetails(int applicationDetailsId,ApplicationDetails applicationDetailsObj) {
		ApplicationDetails existingObj= applicationDetailsRepository.findById(applicationDetailsId).orElseThrow(()-> new ResourceNotFoundException("APPLICATION_DETAILS", "APPLICATION_DETAILS_ID", applicationDetailsId));
		existingObj.setApplicationPlatform(applicationDetailsObj.getApplicationPlatform());
		existingObj.setApplicationStatus(applicationDetailsObj.getApplicationStatus());
		existingObj.setAppliedDate(applicationDetailsObj.getAppliedDate());
		existingObj.setCompanyDetails(applicationDetailsObj.getCompanyDetails());
		existingObj.setDeliveryType(applicationDetailsObj.getDeliveryType());
		existingObj.setInterviewDetails(applicationDetailsObj.getInterviewDetails());
		existingObj.setJobType(applicationDetailsObj.getJobType());
		existingObj.setPositionName(applicationDetailsObj.getPositionName());
		return applicationDetailsRepository.save(existingObj);
	}

	@Override
	public ApplicationDetails getApplicationDetailsById(int applicationDetailsId) {
		return applicationDetailsRepository.findById(applicationDetailsId).orElseThrow(()-> new ResourceNotFoundException("APPLICATION_DETAILS", "APPLICATION_DETAILS_ID", applicationDetailsId));
	}

	@Override
	public void deleteApplicationDetails(int applicationDetailsId) {
		applicationDetailsRepository.findById(applicationDetailsId).orElseThrow(()-> new ResourceNotFoundException("APPLICATION_DETAILS", "APPLICATION_DETAILS_ID", applicationDetailsId));
		applicationDetailsRepository.deleteById(applicationDetailsId);
	}

}
