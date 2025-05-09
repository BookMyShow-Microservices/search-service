package com.project.microservices.searchservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.microservices.searchservice.model.SearchResponse;
import com.project.microservices.searchservice.service.SearchService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
public class SearchController {
	
	private final SearchService searchService;
	
	@Autowired
	public SearchController(SearchService searchService) {
		super();
		this.searchService = searchService;
	}

	/**
	 * @deprecated
	 * This method is outdated. Please use getShowsV2 method instead.
	 */
	@Deprecated
	@GetMapping("/api/shows/search")
	public ResponseEntity<SearchResponse> getShows(@RequestParam @NotBlank String movieName,@RequestParam @NotBlank String theaterCity) {
	    return new ResponseEntity<>(searchService.findTheatersByMovieNameAndTheaterCity(movieName, theaterCity), HttpStatus.OK);
	}
	
	@GetMapping("/api/v2/shows/search")
	public ResponseEntity<SearchResponse> getShowsV2(@RequestParam @NotNull Integer movieId, @RequestParam @NotNull Integer theaterCityId) {
	    return new ResponseEntity<>(searchService.findTheatersByMovieIdAndTheaterCityId(movieId, theaterCityId), HttpStatus.OK);
	}

	/**
	 * @deprecated
	 * This method is outdated. Please use getCitiesV2 method instead.
	 */
	@Deprecated
	@GetMapping("/api/cities")
	public ResponseEntity<List<String>> getCities(){
		return new ResponseEntity<>(searchService.getAllCities(),HttpStatus.OK);
	}
	
	@GetMapping("/api/v2/cities")
	public ResponseEntity<Map<Integer, String>> getCitiesV2(){
		return new ResponseEntity<>(searchService.getAllCitiesV2(),HttpStatus.OK);
	}
	

}
