package com.qa.SpringMovies.service;

import java.util.List;

public interface MovieServiceMethods<T> {

//	Create
	T create (T movie);

//	Read All
	List<T> getAllMovies();

//	Read by ID
	T getById(long id);

//	Update
	T update (long id, T movie);
	
//	Delete
	boolean delete(long id);
}
