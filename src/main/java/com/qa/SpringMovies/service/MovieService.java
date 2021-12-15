package com.qa.SpringMovies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.SpringMovies.domain.Movie;
import com.qa.SpringMovies.repo.MovieRepo;

@Service
public class MovieService implements MovieServiceMethods<Movie>{
	
	private MovieRepo repo;
	
	public MovieService (MovieRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Movie create(Movie movie) {
		return this.repo.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return this.repo.findAll();
	}

	@Override
	public Movie getById(long id) {
		Optional<Movie> optionalMovie = this.repo.findById(id);
		if (optionalMovie.isPresent()) {
			return optionalMovie.get();
		}
		return null;
	}

	@Override
	public Movie update(long id, Movie movie) {
		Optional<Movie> existingMovie = this.repo.findById(id);
		if(existingMovie.isPresent()) {
			Movie existing = existingMovie.get();
			
			existing.setTitle(movie.getTitle());
			existing.setGenre(movie.getGenre());
			existing.setDirector(movie.getDirector());
			existing.setRunTime(movie.getRunTime());
			
			return this.repo.saveAndFlush(existing);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
