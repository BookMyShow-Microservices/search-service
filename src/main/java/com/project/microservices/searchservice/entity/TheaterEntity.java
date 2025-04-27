package com.project.microservices.searchservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="theaters")
public class TheaterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="theaters_theater_id_seq")
	@SequenceGenerator(name ="theaters_theater_id_seq", sequenceName="theaters_theater_id_seq", allocationSize=1)
	@Column(name="theater_id")
	private Integer theaterId;

	@Column(name="theater_name")
	private String theaterName;

	@Column(name="theater_address")
	private String theaterAddress;

	@JsonIgnore
	@Column(name="theater_city")
	private String theaterCity;
	
	@Column(name="theater_city_id")
	private Integer theaterCityId;

	@Column(name="theater_totalseats")
	private Integer theaterTotalseats;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="theater_createdon")
	private Timestamp theaterCreatedon;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="theater_updatedon")
	private Timestamp theaterUpdatedon;
	
	@OneToMany(mappedBy = "theater")
    private List<ShowEntity> shows;
}