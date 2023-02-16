package com.rest.springboot.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.demo.entity.City;
import com.rest.springboot.demo.exception.ResourceNotFoundException;
import com.rest.springboot.demo.repository.CityRepository;
import com.rest.springboot.demo.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public City createCity(City cityObj) {
		return cityRepository.save(cityObj);
	}

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City updateCity(int cityId, City cityObj) {
		City existingObj= cityRepository.findById(cityId).orElseThrow(()-> new ResourceNotFoundException("CITY", "CITY_ID", cityId));
		existingObj.setCityName(cityObj.getCityName());
		existingObj.setStateName(cityObj.getStateName());
		return cityRepository.save(existingObj);
	}

	@Override
	public City getCityById(int cityId) {
		return cityRepository.findById(cityId).orElseThrow(()-> new ResourceNotFoundException("CITY", "CITY_ID", cityId));
	}

	@Override
	public void deleteCity(int cityId) {
		cityRepository.findById(cityId).orElseThrow(()-> new ResourceNotFoundException("CITY", "CITY_ID", cityId));
		cityRepository.deleteById(cityId);
	}

}
