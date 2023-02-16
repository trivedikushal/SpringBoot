package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.InterviewDetails;

public interface InterviewDetailsRepository extends JpaRepository<InterviewDetails, Integer> {

}
