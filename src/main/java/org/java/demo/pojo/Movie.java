package org.java.demo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private LocalDate releaseDate;
	private int ticketPrice;
	
	public Movie() { }
	public Movie(String title, LocalDate releaseDate, int ticketPrice) {
		
		setTitle(title);
		setReleaseDate(releaseDate);
		setTicketPrice(ticketPrice);
	}
	
	public int getId() {
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
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitle() + " - " + getReleaseDate()
			+ "\nticket price: " + getTicketPrice();
	}
}
