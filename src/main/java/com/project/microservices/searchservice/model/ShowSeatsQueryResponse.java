package com.project.microservices.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatsQueryResponse {
	
	private Integer movieId;
	private String movieName;
	private Integer theaterId;
	private String theaterName; 
	private Integer showId;
	private Timestamp showStarttime; 
	private LocalDate showDate;
	private Integer showseatId;
	private String showseatRow;
	private Integer showseatSeatno;
	private Status showseatStatus;
	private Integer showseatSeatTicketCost;

}
