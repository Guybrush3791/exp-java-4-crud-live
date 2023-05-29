package org.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Book;
import org.java.demo.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Book> books = bookService.findAll();
		
		model.addAttribute("books", books);
		
		return "books";
	}
	@PostMapping("/books/by/title")
	public String getBookByTitle(Model model, @RequestParam(required = false) String title) {
		
		List<Book> books = bookService.findByTitle(title);
		model.addAttribute("books", books);
		model.addAttribute("title", title);
		
		return "books";
	}
	
	@GetMapping("/books/{id}")
	public String getBook(
			Model model,
			@PathVariable("id") int id
	) {
		
		Optional<Book> optBook = bookService.findById(id);
		Book book = optBook.get();
		
		model.addAttribute("book", book);
		
		return "book";
	}

	@GetMapping("/books/create")
	public String createBook() {
		
		return "book-create";
	}
	
	@PostMapping("/books/create")
	public String storeBook(@ModelAttribute Book book) {
		
		bookService.save(book);
		
		return "redirect:/";
	}
}
