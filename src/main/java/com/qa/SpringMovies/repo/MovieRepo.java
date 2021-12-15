package com.qa.SpringMovies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.SpringMovies.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{
	


}
