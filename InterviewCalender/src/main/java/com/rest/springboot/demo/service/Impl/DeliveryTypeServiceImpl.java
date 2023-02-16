package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.CompanyDetails;
import com.rest.springboot.demo.entity.DeliveryType;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.DeliveryTypeRepository;
import com.rest.springboot.demo.service.DeliveryTypeService;

@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {

	@Autowired
	private DeliveryTypeRepository deliveryTypeRepository;
	
	@Override
	public DeliveryType createDeliveryType(DeliveryType deliveryTypeObj) {
		return deliveryTypeRepository.save(deliveryTypeObj);
	}

	@Override
	public List<DeliveryType> getAllDeliveryTypes() {
		return deliveryTypeRepository.findAll();
	}

	@Override
	public DeliveryType updateDeliveryType(int deliveryTypeId, DeliveryType deliveryTypeObj) {
		DeliveryType existingObj= deliveryTypeRepository.findById(deliveryTypeId).orElseThrow(()-> new ResourceNotFoundException("DELIVERY_TYPE", "DELIVERY_TYPE_ID", deliveryTypeId));
		existingObj.setDeliveryTypeName(deliveryTypeObj.getDeliveryTypeName());
		return deliveryTypeRepository.save(existingObj);
	}

	@Override
	public DeliveryType getDeliveryTypeById(int deliveryTypeId) {
		return deliveryTypeRepository.findById(deliveryTypeId).orElseThrow(()-> new ResourceNotFoundException("DELIVERY_TYPE", "DELIVERY_TYPE_ID", deliveryTypeId));
	}

	@Override
	public void deleteDeliveryType(int deliveryTypeId) {
		deliveryTypeRepository.findById(deliveryTypeId).orElseThrow(()-> new ResourceNotFoundException("DELIVERY_TYPE", "DELIVERY_TYPE_ID", deliveryTypeId));
		deliveryTypeRepository.deleteById(deliveryTypeId);
	}

}
