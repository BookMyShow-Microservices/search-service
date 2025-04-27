package com.project.microservices.searchservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.microservices.searchservice.model.Status;
import com.project.microservices.searchservice.entity.ShowEntity;
import com.project.microservices.searchservice.utils.JsonTimestampSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="showseats")
public class ShowSeatsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="showseats_showseat_id_seq")
	@SequenceGenerator(name ="showseats_showseat_id_seq", sequenceName="showseats_showseat_id_seq", allocationSize=1)
	@Column(name="showseat_id")
	private Integer showseatId;
    
	@Column(name="showseat_show_id")
	private Integer seatstatusShowId;
	
	@ManyToOne
	@JoinColumn(name="showseat_show_id", nullable = false,insertable=false, updatable=false)
	private ShowEntity show;

	@Column(name="showseat_row")
	private String showseatRow;

	@Column(name="showseat_seatno")
	private Integer showseatSeatno;
    
	@Enumerated(EnumType.ORDINAL)
	@Column(name="showseat_status")
	private Status showseatStatus;
	
	@Column(name="showseat_ticketcost")
	private Integer showseatTicketcost;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="showseat_createdon")
	private Timestamp showseatCreatedon;

	@JsonSerialize(using = JsonTimestampSerializer.class)
	@Column(name="showseat_updatedon")
	private Timestamp showseatUpdatedon;
}