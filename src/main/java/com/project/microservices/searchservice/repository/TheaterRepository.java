package com.project.microservices.searchservice.repository;

import com.project.microservices.searchservice.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
	
	List<TheaterEntity> findByTheaterCity(String theaterCity);
	
	@Query("SELECT DISTINCT theater.theaterCity FROM TheaterEntity theater")
	List<String> searchAllCities();

}
