package com.project.microservices.searchservice.movie.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.microservices.searchservice.exception.MovieNotFoundException;
import com.project.microservices.searchservice.model.SearchQueryResponse;
import com.project.microservices.searchservice.model.SearchQueryResponse1;
import com.project.microservices.searchservice.movie.model.MovieResponse;
import com.project.microservices.searchservice.movie.repository.MovieRepository;
import com.project.microservices.searchservice.show.repository.ShowRepository;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
	
	
	private final MovieRepository movieRepository;
	private final ShowRepository showRepository;
	Integer i = 1;
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, ShowRepository showRepository) {
		super();
		this.movieRepository = movieRepository;
        this.showRepository = showRepository;
    }

	@Override
	public List<SearchQueryResponse> findTheatersByMovieNameAndTheaterCity(String movieName, String theaterCity) {
		return movieRepository.searchByMovieNameAndCity(movieName, theaterCity);
	}
	
	@Override
	public List<SearchQueryResponse1> findTheatersByMovieIdAndTheaterId(Integer movieId, Integer theaterId) {
		return movieRepository.searchByMovieIdAndCityId(movieId, theaterId);
	}

	@Override
	@RateLimiter(name = "myRateLimiter")
	public List<String> SearchByMovieName(String movieName) {
		log.info("Opened this movie search service for {} th", i++);
		List<String> listOfMovieNames = movieRepository.findByMovieName(movieName);
		if(listOfMovieNames.isEmpty()) {
			log.warn("No movie search list found for movieName: {}", movieName);
		    throw new MovieNotFoundException("No list found for the given name: " + movieName);
		}
		return listOfMovieNames;
	}

	@Override
	public List<String> findMoviesByCity(String cityName) {
		List<String> listOfMovieNamesByCity = showRepository.searchByCitiesToGetMovies(cityName);
		if(listOfMovieNamesByCity.isEmpty()) {
			log.warn("No movie search list found for cityName: {}", cityName);
		    throw new MovieNotFoundException("No list found for the given name: " + cityName);
		}
		return listOfMovieNamesByCity;
	}
	
	@Override
	public Map<Integer,String> findMoviesByCityId(Integer cityId) {

		List<MovieResponse> listOfMovieNamesByCity = showRepository.searchByCitiesToGetMovies1(cityId);

	    if (listOfMovieNamesByCity.isEmpty()) {
	        log.warn("No movies found for cityId: {}", cityId);
	        throw new MovieNotFoundException("No movies found for the given city ID: " + cityId);
	    }
        //used java 8 features - reference methods
		return listOfMovieNamesByCity.stream().collect(Collectors.toMap(MovieResponse::getMovieId,MovieResponse::getMovieName));
	}

	@Override
	@RateLimiter(name = "myRateLimiter")
	public Map<String, Integer> SearchByMovieName1(String movieName) {
		var listOfMovieNames = movieRepository.findByMovieName1(movieName); // used java 10 feature
		if(listOfMovieNames.isEmpty()) {
			log.warn("No movie search list found for movieName-v2: {}", movieName);
			throw new MovieNotFoundException("No list found for the given name: " + movieName);
		}
		log.info("Opened this movie -v2 search service  for {} th", i++);
		//used java 8- stream api feature
		//Map<String,Integer> searchMap = listOfMovieNames.stream().collect(Collectors.toMap(MovieResponse::getMovieName,MovieResponse::getMovieId));
		return listOfMovieNames.stream().collect(Collectors.toMap(movieResponse -> movieResponse.getMovieName(),movieResponse -> movieResponse.getMovieId()));
	}



}
