package org.java.demo.pojo;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String author;
	private String publisher;
	private Integer year;
	
	@Column(length = 13, unique = true)
	@NonNull
	@Size(min = 13, max = 13, message = "ISBN must has 13 charachters")
	private String isbn;
	private Integer copies;
	
	public Book() { }
	public Book(String title, String author, String publisher, int year, String isbn, int copies) {
		
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setYear(year);
		setIsbn(isbn);
		setCopies(copies);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitle() + " - " + getAuthor() + " (" + getPublisher() + ")"
				+ "\nyear: " + getYear() 
				+ "\ncopies: " + getCopies()
				+ "\nisbn: " + getIsbn();
	}
}
