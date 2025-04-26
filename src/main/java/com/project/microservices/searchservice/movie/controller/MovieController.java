package com.project.microservices.searchservice.movie.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.microservices.searchservice.movie.service.MovieService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
public class MovieController {
	
private final MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	/**
	 * @deprecated
	 * This method is outdated. Please use getMoviesByNameV2 method instead.
	 */
	@Deprecated
	@GetMapping("/api/movie/search")
	public ResponseEntity<List<String>> getMoviesByName(@RequestParam @NotBlank String movieName) {
	    return new ResponseEntity<>(movieService.SearchByMovieName(movieName), HttpStatus.OK);
	}

	@GetMapping("/api/v2/movie/search")
	public ResponseEntity<Map<String,Integer>> getMoviesByNameV2(@RequestParam @NotBlank String movieName) {
		return new ResponseEntity<>(movieService.SearchByMovieNameV2(movieName), HttpStatus.OK);
	}

	/**
	 * @deprecated
	 * This method is outdated. Please use getMoviesByCityV2 method instead.
	 */
	@Deprecated
	@GetMapping("/api/movie/explore")
	public ResponseEntity<List<String>> getMoviesByCity(@RequestParam @NotBlank String cityName) {
	    return new ResponseEntity<>(movieService.findMoviesByCity(cityName), HttpStatus.OK);
	}
	
	@GetMapping("/api/v2/movie/explore")
	public ResponseEntity<Map<Integer,String>> getMoviesByCityV2(@RequestParam @NotNull Integer cityId) {
	    return new ResponseEntity<>(movieService.findMoviesByCityV2(cityId), HttpStatus.OK);
	}
	

}
