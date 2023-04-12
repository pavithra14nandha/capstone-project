package com.example.demo.movies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int movieid;
private String moviename;
private String language;
private String genres;
private String theatre;
private String showtime;
private String showdate;
private boolean available;
private int price;


}
