package com.project.microservices.searchservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.model.Status;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shows")
public class ShowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shows_show_id_seq")
	@SequenceGenerator(name ="shows_show_id_seq", sequenceName="shows_show_id_seq", allocationSize=1)
	@Column(name="show_id")
	private Integer showId;

	@Column(name="show_date")
	private LocalDate showDate;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="show_starttime")
	private Timestamp showStarttime;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="show_endtime")
	private Timestamp showEndtime;
	
	@Column(name="show_theater_id")
	private Integer showTheaterId;

	@Column(name="show_movie_id")
	private Integer showMovieId;
	
	@ManyToOne
	@JoinColumn(name = "show_theater_id",  nullable = false,insertable=false, updatable=false)
	private TheaterEntity theater;
	
	@ManyToOne
	@JoinColumn(name = "show_movie_id",  nullable = false,insertable=false, updatable=false)
	private MovieEntity movie;

	@Enumerated(EnumType.STRING)
	@Column(name="show_status")
	private Status showStatus;
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShowSeatsEntity> showSeats;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="show_createdon")
	private Timestamp showCreatedon;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="show_updatedon")
	private Timestamp showUpdatedon;
	
}
