package com.project.microservices.searchservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cities_city_id_seq")
	@SequenceGenerator(name ="cities_city_id_seq", sequenceName="cities_city_id_seq", allocationSize=1)
	@Column(name="city_id")
	private Integer cityId;

	@Column(name="city_name")
	private String cityName;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="city_createdon")
	private Timestamp cityCreatedon;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="city_updatedon")
	private Timestamp cityUpdatedon;
}