package com.project.microservices.searchservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeats {
	
	private Integer showseatId;
	private Integer showseatShowId;
	private String showseatRow;
	private Integer showseatSeatno;
	private Status showseatStatus;
	@JsonSerialize(using = JsonTimestampSerializer.class)
	private Timestamp showseatCreatedon;
	@JsonSerialize(using = JsonTimestampSerializer.class)
	private Timestamp showseatUpdatedon;
}
