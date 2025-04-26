package com.project.microservices.searchservice.movie.service;

import java.util.List;
import java.util.Map;
import com.project.microservices.searchservice.model.SearchQueryResponse;
import com.project.microservices.searchservice.model.SearchQueryResponse1;

public interface MovieService {
	
	public List<SearchQueryResponse> findTheatersByMovieNameAndTheaterCity(String movieName, String theaterCity);
	
	public List<SearchQueryResponse1> findTheatersByMovieIdAndTheaterId(Integer movieId, Integer theaterId);

	public List<String> SearchByMovieName(String movieName);

	public Map<String,Integer> SearchByMovieNameV2(String movieName);

	public List<String> findMoviesByCity(String cityName);

	public Map<Integer, String> findMoviesByCityV2(Integer cityId);

}
