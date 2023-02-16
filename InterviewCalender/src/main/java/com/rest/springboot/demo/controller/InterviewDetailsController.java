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

	import com.rest.springboot.demo.entity.InterviewDetails;
	import com.rest.springboot.demo.service.InterviewDetailsService;

	@RestController
	@RequestMapping("/api/interviewDetails")
	public class InterviewDetailsController {
		
		@Autowired
		private InterviewDetailsService interviewDetailsService;
		
		@PostMapping("/create")
		public ResponseEntity<InterviewDetails> createInterviewDetails(@RequestBody InterviewDetails interviewDetails){
			return new ResponseEntity<InterviewDetails>(interviewDetailsService.createInterviewDetails(interviewDetails), HttpStatus.CREATED);
		}
		
		@GetMapping("/allInterviewDetails")
		public ResponseEntity<List<InterviewDetails>> getAllInterviewDetails(){
			return ResponseEntity.ok(interviewDetailsService.getAllInterviewDetails());
		}
		
		@PutMapping("/{interviewDetailsId}")
		public ResponseEntity<InterviewDetails> updateInterviewDetails(@PathVariable int interviewDetailsId,@RequestBody InterviewDetails interviewDetails){
			return new ResponseEntity<InterviewDetails>(interviewDetailsService.updateInterviewDetails(interviewDetailsId,interviewDetails), HttpStatus.OK);
		}
		
		@GetMapping("/{interviewDetailsId}")
		public ResponseEntity<InterviewDetails> getInterviewDetailsById(@PathVariable int interviewDetailsId){
			return ResponseEntity.ok(interviewDetailsService.getInterviewDetailsById(interviewDetailsId));
		}
		
		@DeleteMapping("{interviewDetailsId}")
		public void deleteInterviewDetails(@PathVariable int interviewDetailsId){
			interviewDetailsService.deleteInterviewDetails(interviewDetailsId);
		}
	}
