package com.example.demo.movies;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*")
public class MovieController {
@Autowired
MovieService movieservice;

Logger log=Logger.getAnonymousLogger();

@PostMapping("/insert")
public ResponseEntity<Movie> insert(@RequestBody Movie movie)
{
	movie=movieservice.insertmovie(movie);
	if(movie!=null)
	{
		log.info("movie inserted successfully");
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
	}
	else
	{
		log.info("movie is not inserted");
		return new ResponseEntity<>(movie,HttpStatus.NOT_FOUND);
	}
}
@PutMapping("/update/{movieid}")
public ResponseEntity<Movie> updatemovie(@PathVariable int movieid,@RequestBody Movie newmovie)
{
	Movie nmovie=movieservice.updatemovie(movieid, newmovie);
if(nmovie!=null)
{
	log.info("-------updated---------");
	return new ResponseEntity<>(newmovie,HttpStatus.CREATED);
}
else
{
	log.info("-------not updated---------");
	return new ResponseEntity<>(newmovie,HttpStatus.NOT_FOUND);
}
}
@DeleteMapping("/delete/{movieid}")
public ResponseEntity<List<Movie>> deletemovie(@PathVariable int movieid)
{
	List<Movie> movie=movieservice.deletemovie(movieid);
	if(movie!=null)
	{
		log.info("------------deleted----------");
		return ResponseEntity.ok(movieservice.viewallmovie());
	}
	else
	{
		log.info("movie id not found");
		return  ResponseEntity.ok(movieservice.deletemovie(movieid));
	}
}
@GetMapping("/viewall")
public ResponseEntity<List<Movie>> getallmovies()
{
	log.info("in viewall controller");
	return ResponseEntity.ok(movieservice.viewallmovie());
}

@GetMapping("/viewname/{moviename}")
public ResponseEntity<List<Movie>> viewbymoviename(@PathVariable String moviename)
{
	log.info("in viewbymoviename "+moviename);
	return ResponseEntity.ok(movieservice.getbymoviename(moviename));
}
@GetMapping("/viewlanguage/{language}")
public ResponseEntity<List<Movie>> viewbylanguage(@PathVariable String language)
{
	log.info("in viewbylanguage "+language);
	return ResponseEntity.ok(movieservice.getbymovielanguage(language));
}
@GetMapping("/viewbygenres/{genres}")
public ResponseEntity<List<Movie>> viewbygenres(@PathVariable String genres)
{
	log.info("in viewbygenres "+genres);
	return ResponseEntity.ok(movieservice.getbymoviegenres(genres));
}
@GetMapping("/viewbyshowdate/{showdate}")
public ResponseEntity<List<Movie>> viewbyshowdate(@PathVariable String showdate)
{
	log.info("in viewbyshowdate "+showdate);
	if(showdate!=null)
	{
		log.info(showdate);
	return ResponseEntity.ok(movieservice.getbyshowdate(showdate));
	}
	else
	{
		return ResponseEntity.ok(null);
	}
}
@GetMapping("/viewtheatre/{theatre}")
public ResponseEntity<List<Movie>> viewbytheatre(@PathVariable String theatre)
{
       log.info("in viewbytheatre "+theatre);
	return ResponseEntity.ok(movieservice.getbytheatre(theatre));

}
@GetMapping("/viewticketavailable/{available}")
public ResponseEntity<List<Movie>> viewbyavailable(@PathVariable boolean available)
{
	log.info("in viewbyticketavailable ");
	return ResponseEntity.ok(movieservice.getbyticketavailable(available));
	
}
@GetMapping("/viewonlytheatres")
public ResponseEntity<List<String>> viewonlytheatre()
{
	log.info("in theatresonly controller");
	return ResponseEntity.ok(movieservice.getonlytheatres());
}

/*@PutMapping("/updatecost/{movieid}")
public ResponseEntity<Integer> updatetotalcost(@PathVariable int movieid)
{
	return ResponseEntity.ok(movieservice.totalcost(movieid));
}*/
}

