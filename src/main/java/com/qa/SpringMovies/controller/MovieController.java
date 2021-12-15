package com.qa.SpringMovies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringMovies.domain.Movie;
import com.qa.SpringMovies.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	private MovieService service;
	
	private MovieController(MovieService service) {
		this.service = service;
	}
	
	//	Create
		@PostMapping("/create")
		public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
			return new ResponseEntity<Movie>(this.service.create(movie), HttpStatus.CREATED);
		}
		
	//	Read all
		@GetMapping("/getAll")
		public ResponseEntity <List <Movie>> allMovies() {
			return new ResponseEntity<List<Movie>>(this.service.getAllMovies(), HttpStatus.OK);
		}
		
	//	Read by ID
		@GetMapping("/readById/{id}")
		public ResponseEntity<Movie> moviesById(long id) {
			return new ResponseEntity<Movie>(this.service.getById(id), HttpStatus.OK);
		}
		
	//	Update
		@PutMapping("/update/{id}")
		public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie){
			return new ResponseEntity<Movie>(this.service.update(id, movie), HttpStatus.ACCEPTED);
		}
		
	//	Delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> deleteMovie(@PathVariable long id){
			return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
				new ResponseEntity <Boolean> (HttpStatus.NOT_FOUND);
		}
		
}
