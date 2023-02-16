package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.ApplicationDetails;

public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, Integer>{

}
