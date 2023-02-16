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

import com.rest.springboot.demo.entity.Company;
import com.rest.springboot.demo.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/create")
	public ResponseEntity<Company> createCompany(@RequestBody Company company){
		return new ResponseEntity<Company>(companyService.createCompany(company), HttpStatus.CREATED);
	}
	
	@GetMapping("/allCompanies")
	public ResponseEntity<List<Company>> getAllCompanies(){
		return ResponseEntity.ok(companyService.getAllCompanies());
	}
	
	@PutMapping("/{companyId}")
	public ResponseEntity<Company> updateCompany(@PathVariable int companyId,@RequestBody Company company){
		return new ResponseEntity<Company>(companyService.updateCompany(companyId,company), HttpStatus.OK);
	}
	
	@GetMapping("/{companyId}")
	public ResponseEntity<Company> getCompanyById(@PathVariable int companyId){
		return ResponseEntity.ok(companyService.getCompanyById(companyId));
	}
	
	@DeleteMapping("{companyId}")
	public void deleteCompany(@PathVariable int companyId){
		companyService.deleteCompany(companyId);
	}
}
