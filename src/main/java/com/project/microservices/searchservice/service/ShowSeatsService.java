package com.project.microservices.searchservice.service;

import com.project.microservices.searchservice.model.ShowSeatsResponse;

public interface ShowSeatsService {
		
	public ShowSeatsResponse findShowSeatDetails(int showId);
}
