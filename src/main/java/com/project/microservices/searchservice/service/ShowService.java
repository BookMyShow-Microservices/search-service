package com.project.microservices.searchservice.service;

import com.project.microservices.searchservice.model.ShowDetails;

public interface ShowService {
	
	public ShowDetails findShowDetails(Integer showId);

}
