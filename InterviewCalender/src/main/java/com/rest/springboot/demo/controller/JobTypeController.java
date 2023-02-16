package com.rest.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.demo.entity.JobType;
import com.rest.springboot.demo.service.JobTypeService;

@RestController
@RequestMapping("/api/jobType")
public class JobTypeController {
	
	@Autowired
	private JobTypeService jobTypeService;
	
	@PostMapping("/create")
	public ResponseEntity<JobType> createJobType(@RequestBody JobType jobType){
		return new ResponseEntity<JobType>(jobTypeService.createJobType(jobType), HttpStatus.CREATED);
	}
	
	@GetMapping("/allJobTypes")
	public ResponseEntity<List<JobType>> getAllJobTypes(){
		return ResponseEntity.ok(jobTypeService.getAllJobTypes());
	}
	
	@PutMapping("/{jobTypeId}")
	public ResponseEntity<JobType> updateJobType(@PathVariable int jobTypeId,@RequestBody JobType jobType){
		return new ResponseEntity<JobType>(jobTypeService.updateJobType(jobTypeId,jobType), HttpStatus.OK);
	}
	
	@GetMapping("/{jobTypeId}")
	public ResponseEntity<JobType> getJobTypeById(@PathVariable int jobTypeId){
		return ResponseEntity.ok(jobTypeService.getJobTypeById(jobTypeId));
	}
	
	@DeleteMapping("{jobTypeId}")
	public void deleteJobType(@PathVariable int jobTypeId){
		jobTypeService.deleteJobType(jobTypeId);
	}
}
