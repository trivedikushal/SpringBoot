package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.CompanyDetails;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {

}
