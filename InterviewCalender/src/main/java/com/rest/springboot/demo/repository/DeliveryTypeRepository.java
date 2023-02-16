package com.rest.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.demo.entity.DeliveryType;

public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Integer>{

}
