package org.java.demo.repo;

import org.java.demo.pojo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
