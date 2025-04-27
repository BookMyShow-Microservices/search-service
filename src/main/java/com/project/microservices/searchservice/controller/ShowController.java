package com.project.microservices.searchservice.controller;

import com.project.microservices.searchservice.model.ShowDetails;
import com.project.microservices.searchservice.service.ShowService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {
	
	private final ShowService showService;
	
	@Autowired
	public ShowController(ShowService showService) {
		super();
		this.showService = showService;
	}

	@GetMapping("/api/showdetails")
	public ResponseEntity<ShowDetails> searchShowDetails(@RequestParam @NotNull Integer showId) {
	    return new ResponseEntity<>(showService.findShowDetails(showId), HttpStatus.OK);
	}

}
