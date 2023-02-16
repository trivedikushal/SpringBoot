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

	import com.rest.springboot.demo.entity.DeliveryType;
	import com.rest.springboot.demo.service.DeliveryTypeService;

	@RestController
	@RequestMapping("/api/deliveryType")
	public class DeliveryTypeController {
		
		@Autowired
		private DeliveryTypeService deliveryTypeService;
		
		@PostMapping("/create")
		public ResponseEntity<DeliveryType> createDeliveryType(@RequestBody DeliveryType deliveryType){
			return new ResponseEntity<DeliveryType>(deliveryTypeService.createDeliveryType(deliveryType), HttpStatus.CREATED);
		}
		
		@GetMapping("/allDeliveryTypes")
		public ResponseEntity<List<DeliveryType>> getAllDeliveryTypes(){
			return ResponseEntity.ok(deliveryTypeService.getAllDeliveryTypes());
		}
		
		@PutMapping("/{deliveryTypeId}")
		public ResponseEntity<DeliveryType> updateDeliveryType(@PathVariable int deliveryTypeId,@RequestBody DeliveryType deliveryType){
			return new ResponseEntity<DeliveryType>(deliveryTypeService.updateDeliveryType(deliveryTypeId,deliveryType), HttpStatus.OK);
		}
		
		@GetMapping("/{deliveryTypeId}")
		public ResponseEntity<DeliveryType> getDeliveryTypeById(@PathVariable int deliveryTypeId){
			return ResponseEntity.ok(deliveryTypeService.getDeliveryTypeById(deliveryTypeId));
		}
		
		@DeleteMapping("{deliveryTypeId}")
		public void deleteDeliveryType(@PathVariable int deliveryTypeId){
			deliveryTypeService.deleteDeliveryType(deliveryTypeId);
		}
	}
