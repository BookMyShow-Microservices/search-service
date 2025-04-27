package com.project.microservices.searchservice.repository;

import com.project.microservices.searchservice.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
	
	@Query("SELECT DISTINCT cities.cityName FROM CityEntity cities")
	List<String> searchAllCities();

}
