package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
