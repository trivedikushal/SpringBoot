package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
