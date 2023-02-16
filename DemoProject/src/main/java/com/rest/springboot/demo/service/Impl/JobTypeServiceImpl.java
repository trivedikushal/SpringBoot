package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.InterviewDetails;
import com.rest.springboot.demo.entity.JobType;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.JobTypeRepository;
import com.rest.springboot.demo.service.JobTypeService;

@Service
public class JobTypeServiceImpl implements JobTypeService{

	@Autowired
	private JobTypeRepository jobTypeRepository;
	
	@Override
	public JobType createJobType(JobType jobTypeObj) {
		return jobTypeRepository.save(jobTypeObj);
	}

	@Override
	public List<JobType> getAllJobTypes() {
		return jobTypeRepository.findAll();
	}

	@Override
	public JobType updateJobType(int jobTypeId, JobType jobTypeObj) {
		JobType existingObj= jobTypeRepository.findById(jobTypeId).orElseThrow(()-> new ResourceNotFoundException("JOB_TYPE", "JOB_TYPE_ID", jobTypeId));
		existingObj.setJobTypeName(jobTypeObj.getJobTypeName());
		return jobTypeRepository.save(existingObj);
	}

	@Override
	public JobType getJobTypeById(int jobTypeId) {
		return jobTypeRepository.findById(jobTypeId).orElseThrow(()-> new ResourceNotFoundException("JOB_TYPE", "JOB_TYPE_ID", jobTypeId));
	}

	@Override
	public void deleteJobType(int jobTypeId) {
		jobTypeRepository.findById(jobTypeId).orElseThrow(()-> new ResourceNotFoundException("JOB_TYPE", "JOB_TYPE_ID", jobTypeId));
		jobTypeRepository.deleteById(jobTypeId);
	}

}
