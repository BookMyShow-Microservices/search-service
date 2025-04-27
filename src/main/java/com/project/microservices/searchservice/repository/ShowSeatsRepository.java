package com.project.microservices.searchservice.repository;

import com.project.microservices.searchservice.entity.ShowSeatsEntity;
import com.project.microservices.searchservice.model.ShowSeatsQueryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Integer> {

	@Query("SELECT new com.project.microservices.searchservice.model.ShowSeatsQueryResponse(" +
		       "movies.movieId, movies.movieName, " +
		       "theaters.theaterId, theaters.theaterName, " +
		       "shows.showId,shows.showStarttime,shows.showDate," +
		       "showseats.showseatId, showseats.showseatRow, " +
		       "showseats.showseatSeatno, showseats.showseatStatus , showseats.showseatTicketcost) " +
		       "FROM ShowEntity shows " +
		       "JOIN shows.theater theaters " +
		       "JOIN shows.movie movies " +
		       "JOIN shows.showSeats showseats " +
		       "WHERE shows.showId = :showId " +
		       "ORDER BY showseats.showseatRow, showseats.showseatSeatno")
	public List<ShowSeatsQueryResponse> findByShowSeatsFromShowId(@Param("showId") int showId);
}
