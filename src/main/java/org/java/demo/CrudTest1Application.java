package org.java.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Book;
import org.java.demo.pojo.Movie;
import org.java.demo.serv.BookService;
import org.java.demo.serv.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@SpringBootApplication
public class CrudTest1Application implements CommandLineRunner {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudTest1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Movie m = new Movie("Fantozzi", LocalDate.parse("1990-01-01"), 20);
		System.out.println(m);
		
		movieService.save(m);
		
		List<Movie> movies = movieService.findAll();
		System.out.println(movies);
		
		Optional<Movie> movie = movieService.getMovieById(20);
		if (movie.isPresent()) {
			
			Movie optM = movie.get();
			
			System.out.println("Movie con id 20");
			System.out.println("--------------");
			System.out.println(optM);
		} else
			System.out.println("Movie con id 20 non trovato :-(");
		
		// ----------------------------------------------------------------
		System.out.println("\n----------------------------------------------------------------\n");
		
		Book b1 = new Book("mio libro 1", "io", "sempre io", 2023, "1234567890123", 1943893);
		Book b2 = new Book("mio libro 2", "io", "sempre io", 2023, "1234567890124", 1943893);
		Book b3 = new Book("mio libro 3", "io", "sempre io", 2023, "1234567890125", 1943893);
		Book b4 = new Book("mio libro 4", "io", "sempre io", 2023, "1234567890126", 1943893);
		Book b5 = new Book("mio libro 5", "io", "sempre io", 2023, "1234567890127", 1943893);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		
		bookService.save(b1);
		bookService.save(b2);
		bookService.save(b3);
		bookService.save(b4);
		bookService.save(b5);
		
		List<Book> books = bookService.findAll();
		System.out.println(books);
		
		Optional<Book> optBook = bookService.findById(1);
		
		if (optBook.isPresent()) {
			
			Book dbBook = optBook.get();
			
			System.out.println("Book con id 1");
			System.out.println("--------------");
			System.out.println(dbBook);
		} else 
			System.out.println("Book con id 1 non trovato :-(");
	}
}
