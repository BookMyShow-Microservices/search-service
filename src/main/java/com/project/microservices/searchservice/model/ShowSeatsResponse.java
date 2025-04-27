package com.project.microservices.searchservice.model;

import com.project.microservices.searchservice.model.ShowDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatsResponse {
	
	private ShowDetails showDetails;
	private HashMap<String,HashMap<Integer, ShowSeatSubDetails>> seatDetails;
	//String-(key): row , value: ((key)int-seatno,(value)Status-availablity)
}
	