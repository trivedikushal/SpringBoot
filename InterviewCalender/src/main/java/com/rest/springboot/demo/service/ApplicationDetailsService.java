package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.ApplicationDetails;

public interface ApplicationDetailsService {
	
	public ApplicationDetails createApplicationDetails(ApplicationDetails applicationDetailsObj);
	
	public List<ApplicationDetails> getAllApplicationDetails();
	
	public ApplicationDetails updateApplicationDetails(int applicationDetailsId,ApplicationDetails applicationDetailsObj);
	
	public ApplicationDetails getApplicationDetailsById(int applicationDetailsId);
	
	public void deleteApplicationDetails(int applicationDetailsId);

}
