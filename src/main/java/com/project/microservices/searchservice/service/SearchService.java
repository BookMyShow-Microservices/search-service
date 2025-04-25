package com.project.microservices.searchservice.service;

import java.util.List;
import java.util.Map;

import com.project.microservices.searchservice.model.SearchResponse;

public interface SearchService {

	public SearchResponse findTheatersByMovieNameAndTheaterCity(String movieName, String theaterCity);

	public SearchResponse findTheatersByMovieIdAndTheaterCityId(Integer movieId, Integer theaterCityId);
	
	public List<String> getAllCities();
	
	public Map<Integer, String> getAllCities1();

	

}
