package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.DeliveryType;
import com.rest.springboot.demo.entity.InterviewDetails;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.InterviewDetailsRepository;
import com.rest.springboot.demo.service.InterviewDetailsService;

@Service
public class InterviewDetailsServiceImpl implements InterviewDetailsService {

	@Autowired
	private InterviewDetailsRepository interviewDetailsRepository;
	
	@Override
	public InterviewDetails createInterviewDetails(InterviewDetails interviewDetailsObj) {
		return interviewDetailsRepository.save(interviewDetailsObj);
	}

	@Override
	public List<InterviewDetails> getAllInterviewDetails() {
		return interviewDetailsRepository.findAll();
	}

	@Override
	public InterviewDetails updateInterviewDetails(int interviewDetailsId, InterviewDetails interviewDetailsObj) {
		InterviewDetails existingObj= interviewDetailsRepository.findById(interviewDetailsId).orElseThrow(()-> new ResourceNotFoundException("INTERVIEW_DETAILS", "INTERVIEW_DETAILS_ID", interviewDetailsId));
		existingObj.setInterviewDate(interviewDetailsObj.getInterviewDate());
		existingObj.setInterviewTime(interviewDetailsObj.getInterviewTime());
		return interviewDetailsRepository.save(existingObj);
	}

	@Override
	public InterviewDetails getInterviewDetailsById(int interviewDetailsId) {
		return interviewDetailsRepository.findById(interviewDetailsId).orElseThrow(()-> new ResourceNotFoundException("INTERVIEW_DETAILS", "INTERVIEW_DETAILS_ID", interviewDetailsId));
	}

	@Override
	public void deleteInterviewDetails(int interviewDetailsId) {
		interviewDetailsRepository.findById(interviewDetailsId).orElseThrow(()-> new ResourceNotFoundException("INTERVIEW_DETAILS", "INTERVIEW_DETAILS_ID", interviewDetailsId));
		interviewDetailsRepository.deleteById(interviewDetailsId);
	}

}
