package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.JobType;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {

}
