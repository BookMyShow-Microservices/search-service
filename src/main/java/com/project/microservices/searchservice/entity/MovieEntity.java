package com.project.microservices.searchservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.entity.ShowEntity;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movies")
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="movies_movie_id_seq")
	@SequenceGenerator(name ="movies_movie_id_seq", sequenceName="movies_movie_id_seq", allocationSize=1)
	@Column(name="movie_id")
	private Integer movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_language")
	private String movieLanguage;

	@Column(name="movie_genre")
	private String movieGenre;

	@Column(name="movie_duration")
	private Duration movieDuration;

	@Column(name="movie_releasedate")
	private Date movieReleasedate;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="movie_createdon")
	private Timestamp movieCreatedon;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="movie_updatedon")
	private Timestamp movieUpdatedon;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<ShowEntity> shows;

}