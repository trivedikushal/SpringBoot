package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.JobType;

public interface JobTypeService {
	
	public JobType createJobType(JobType jobTypeObj);
	
	public List<JobType> getAllJobTypes();
	
	public JobType updateJobType(int jobTypeId,JobType jobTypeObj);
	
	public JobType getJobTypeById(int jobTypeId);
	
	public void deleteJobType(int jobTypeId);

}
