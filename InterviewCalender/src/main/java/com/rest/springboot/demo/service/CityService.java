package com.rest.springboot.demo.service;

import java.util.List;

import com.rest.springboot.demo.entity.City;

public interface CityService {
	
	public City createCity(City cityObj);
	
	public List<City> getAllCities();
	
	public City updateCity(int cityId,City cityObj);
	
	public City getCityById(int cityId);
	
	public void deleteCity(int cityId);

}
