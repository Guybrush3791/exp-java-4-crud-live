package org.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Book;
import org.java.demo.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Book> books = bookService.findAllNotDeleted();
		
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
	public String createBook(Model model) {
		
		model.addAttribute("book", new Book());
		
		return "book-create";
	}
	
	@PostMapping("/books/create")
	public String storeBook(
			Model model,
			@Valid @ModelAttribute Book book,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			for (ObjectError err : bindingResult.getAllErrors()) 
				System.err.println("error: " + err.getDefaultMessage());
			
			model.addAttribute("book", book);
			model.addAttribute("errors", bindingResult);
			
//			if (bindingResult.hasFieldErrors("title"))
			bindingResult.getFieldError("title").getDefaultMessage();
			
			return "book-create";
		}
		
		bookService.save(book);
		
		return "redirect:/";
	}
	
	@GetMapping("/books/delete/{id}")
	public String deleteBook(
			@PathVariable int id
		) {
		
		Optional<Book> bookOpt = bookService.findById(id);
		Book book = bookOpt.get();
		bookService.deleteBook(book);
		
		return "redirect:/";
	}
	@GetMapping("/books/soft-delete/{id}")
	public String softDeleteBook(
			@PathVariable int id
		) {
		
		Optional<Book> bookOpt = bookService.findById(id);
		Book book = bookOpt.get();
		
		book.setDeleted(true);
		bookService.save(book);
		
		return "redirect:/";
	}
	
	@GetMapping("/books/update/{id}")
	public String editBook(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Book> bookOpt = bookService.findById(id);
		Book book = bookOpt.get();
		model.addAttribute("book", book);
		
		return "book-update";
	}
	@PostMapping("/books/update/{id}")
	public String updateBook(
			@PathVariable int id,
			@ModelAttribute Book book
		) {
		
		bookService.save(book);
		
		return "redirect:/";
	}
}















