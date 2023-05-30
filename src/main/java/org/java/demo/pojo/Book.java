package org.java.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Title can't be null")
	private String title;
	@NotBlank(message = "Author can't be null")
	private String author;
	@NotBlank(message = "Publisher can't be null")
	private String publisher;
	
	@Min(value = -1000, message = "Year has to be from -1000 to 2100")
	@Max(value = 2100)
	private Integer year;
	
	@Column(length = 13, unique = true)
	@Size(min = 13, max = 13, message = "ISBN has to be formed from 13 charachters")
	private String isbn;
	@Min(value = 0, message = "Copies has to be greater or equal to 0")
	private Integer copies;
	
	private boolean deleted = false;
	
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
	public void setId(Integer id) {
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
	public void setYear(Integer year) {
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
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitle() + " - " + getAuthor() + " (" + getPublisher() + ")"
				+ "\nyear: " + getYear() 
				+ "\ncopies: " + getCopies()
				+ "\nisbn: " + getIsbn();
	}
}
