package org.java.demo.repo;

import java.util.List;

import org.java.demo.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepo extends JpaRepository<Book, Integer> {

	public List<Book> findByTitleContaining(String title);
}
