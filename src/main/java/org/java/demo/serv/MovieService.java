package org.java.demo.serv;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Movie;
import org.java.demo.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	public List<Movie> findAll() {
		
		return movieRepo.findAll();
	}
	public Movie save(Movie movie) {
		
		return movieRepo.save(movie);
	}
	public Optional<Movie> getMovieById(int id) {
		
		return movieRepo.findById(id);
	}
}
