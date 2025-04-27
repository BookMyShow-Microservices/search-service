package com.project.microservices.searchservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
	
	private Integer showId;
	private LocalDate showDate;
	@JsonSerialize(using = JsonTimestampSerializer.class)
	private Timestamp showStarttime;
	@JsonSerialize(using = JsonTimestampSerializer.class)
	private Timestamp showEndtime;
	private Integer showTheaterId;
	private Integer showMovieId;
	private Status showStatus;
	@JsonSerialize(using = JsonTimestampSerializer.class)
	private Timestamp showCreatedon;
	@JsonSerialize(using = JsonTimestampSerializer.class)
	private Timestamp showUpdatedon;
}
