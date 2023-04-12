package com.example.demo.movies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepo extends JpaRepository<Movie, Integer>{

	@Query(value="select * from movie where moviename=?",nativeQuery = true)
	public List<Movie> findbymoviename(String moviename);
	
	@Query(value="select * from movie where language=?",nativeQuery = true)
	public List<Movie> findbylanguage(String language);
	
	@Query(value="select * from movie where genres=?",nativeQuery = true)
	public List<Movie> findbygenres(String genres);
	
	@Query(value="select * from movie where theatre=?",nativeQuery = true)
	public List<Movie> findbytheatre(String theatre);
	
	@Query(value="select * from movie where showdate=?",nativeQuery = true)
	public List<Movie> findbyshowdate(String showdate);
	
	@Query(value="select * from movie where available=?",nativeQuery = true)
	public List<Movie> findbyticketavailable(boolean available);

	@Query(value="select m.theatre from movie m",nativeQuery = true)
	public List<String> findonlytheatres();
	
	@Query(value="select price*noofseats as totalcost from movie where movieid=?",nativeQuery = true)
	public int findtotalcost(int movieid);
	
	@Query(value="update movie set totalcost=price*noofseats where movieid=?",nativeQuery=true)
	public int updatetotalcost(int movieid);

}
