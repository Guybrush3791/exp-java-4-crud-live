package org.java.demo.serv;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Book;
import org.java.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> findAll() {
		
		return bookRepo.findAll();
	}
	public List<Book> findAllNotDeleted() {
		
		return bookRepo.findByDeletedFalse();
	}
	public Book save(Book book) {
		
		return bookRepo.save(book);
	}
	public Optional<Book> findById(int id) {
		
		return bookRepo.findById(id);
	}
	public List<Book> findByTitle(String title) {
		
		return bookRepo.findByTitleContainingAndDeletedFalse(title);
	}
	public void deleteBook(Book book) {
		
		bookRepo.delete(book);
	}
}
