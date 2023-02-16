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

	import com.rest.springboot.demo.entity.ApplicationDetails;
	import com.rest.springboot.demo.service.ApplicationDetailsService;

	@RestController
	@RequestMapping("/api/applicationDetails")
	public class ApplicationDetailsController {
		
		@Autowired
		private ApplicationDetailsService applicationDetailsService;
		
		@PostMapping("/create")
		public ResponseEntity<ApplicationDetails> createApplicationDetails(@RequestBody ApplicationDetails applicationDetails){
			return new ResponseEntity<ApplicationDetails>(applicationDetailsService.createApplicationDetails(applicationDetails), HttpStatus.CREATED);
		}
		
		@GetMapping("/allApplicationDetails")
		public ResponseEntity<List<ApplicationDetails>> getAllApplicationDetails(){
			return ResponseEntity.ok(applicationDetailsService.getAllApplicationDetails());
		}
		
		@PutMapping("/{applicationDetailsId}")
		public ResponseEntity<ApplicationDetails> updateApplicationDetails(@PathVariable int applicationDetailsId,@RequestBody ApplicationDetails applicationDetails){
			return new ResponseEntity<ApplicationDetails>(applicationDetailsService.updateApplicationDetails(applicationDetailsId,applicationDetails), HttpStatus.OK);
		}
		
		@GetMapping("/{applicationDetailsId}")
		public ResponseEntity<ApplicationDetails> getApplicationDetailsById(@PathVariable int applicationDetailsId){
			return ResponseEntity.ok(applicationDetailsService.getApplicationDetailsById(applicationDetailsId));
		}
		
		@DeleteMapping("{applicationDetailsId}")
		public void deleteApplicationDetails(@PathVariable int applicationDetailsId){
			applicationDetailsService.deleteApplicationDetails(applicationDetailsId);
		}
	}
