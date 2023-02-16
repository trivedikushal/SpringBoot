package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.InterviewDetails;

public interface InterviewDetailsService {
	
	public InterviewDetails createInterviewDetails(InterviewDetails interviewDetailsObj);
	
	public List<InterviewDetails> getAllInterviewDetails();
	
	public InterviewDetails updateInterviewDetails(int interviewDetailsId,InterviewDetails interviewDetailsObj);
	
	public InterviewDetails getInterviewDetailsById(int interviewDetailsId);
	
	public void deleteInterviewDetails(int interviewDetailsId);

}
