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

import com.rest.springboot.demo.entity.City;
import com.rest.springboot.demo.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@PostMapping()
	public ResponseEntity<City> createCity(@RequestBody City city){
		return new ResponseEntity<City>(cityService.createCity(city), HttpStatus.CREATED);
	}
	
	@GetMapping("/allCities")
	public ResponseEntity<List<City>> getAllCities(){
		return ResponseEntity.ok(cityService.getAllCities());
	}
	
	@PutMapping("/{cityId}")
	public ResponseEntity<City> updateCity(@PathVariable int cityId,@RequestBody City city){
		return new ResponseEntity<City>(cityService.updateCity(cityId,city), HttpStatus.OK);
	}
	
	@GetMapping("/{cityId}")
	public ResponseEntity<City> getCityById(@PathVariable int cityId){
		return ResponseEntity.ok(cityService.getCityById(cityId));
	}
	
	@DeleteMapping("{cityId}")
	public void deleteCity(@PathVariable int cityId){
		cityService.deleteCity(cityId);
	}
}
