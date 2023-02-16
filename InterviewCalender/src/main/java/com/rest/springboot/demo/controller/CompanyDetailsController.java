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

	import com.rest.springboot.demo.entity.CompanyDetails;
	import com.rest.springboot.demo.service.CompanyDetailsService;

	@RestController
	@RequestMapping("/api/companyDetails")
	public class CompanyDetailsController {
		
		@Autowired
		private CompanyDetailsService companyDetailsService;
		
		@PostMapping("/create")
		public ResponseEntity<CompanyDetails> createCompanyDetails(@RequestBody CompanyDetails companyDetails){
			return new ResponseEntity<CompanyDetails>(companyDetailsService.createCompanyDetails(companyDetails), HttpStatus.CREATED);
		}
		
		@GetMapping("/allCompanyDetails")
		public ResponseEntity<List<CompanyDetails>> getAllCompanyDetails(){
			return ResponseEntity.ok(companyDetailsService.getAllCompanyDetails());
		}
		
		@PutMapping("/{companyDetailsId}")
		public ResponseEntity<CompanyDetails> updateCompanyDetails(@PathVariable int companyDetailsId,@RequestBody CompanyDetails companyDetails){
			return new ResponseEntity<CompanyDetails>(companyDetailsService.updateCompanyDetails(companyDetailsId,companyDetails), HttpStatus.OK);
		}
		
		@GetMapping("/{companyDetailsId}")
		public ResponseEntity<CompanyDetails> getCompanyDetailsById(@PathVariable int companyDetailsId){
			return ResponseEntity.ok(companyDetailsService.getCompanyDetailsById(companyDetailsId));
		}
		
		@DeleteMapping("{companyDetailsId}")
		public void deleteCompanyDetails(@PathVariable int companyDetailsId){
			companyDetailsService.deleteCompanyDetails(companyDetailsId);
		}
	}
