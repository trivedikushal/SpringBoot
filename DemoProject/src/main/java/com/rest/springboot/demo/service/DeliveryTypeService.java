package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.DeliveryType;

public interface DeliveryTypeService {
	
	public DeliveryType createDeliveryType(DeliveryType deliveryTypeObj);
	
	public List<DeliveryType> getAllDeliveryTypes();
	
	public DeliveryType updateDeliveryType(int deliveryTypeId,DeliveryType deliveryTypeObj);
	
	public DeliveryType getDeliveryTypeById(int deliveryTypeId);
	
	public void deleteDeliveryType(int deliveryTypeId);

}
