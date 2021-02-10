package com.alexejzvzdn.library.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="albums")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="author_id")
	private Author author;
	
	@Column(name="release_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;
	
	@Column(name="manufacture_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufactureDate;
	
	@Column(name="condition")
	private String condition;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="album")
	private List<Track> tracks;
	
	public Album() {
	}

	public Album(String name, Author author, Date releaseDate, Date manufactureDate, String condition,
			List<Track> tracks) {
		this.name = name;
		this.author = author;
		this.releaseDate = releaseDate;
		this.manufactureDate = manufactureDate;
		this.condition = condition;
		this.tracks = tracks;
	}
	
	public Album(int id, String name, Author author, Date releaseDate, Date manufactureDate, String condition,
			List<Track> tracks) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.releaseDate = releaseDate;
		this.manufactureDate = manufactureDate;
		this.condition = condition;
		this.tracks = tracks;
	}

	public Album(String name, Author author, Date releaseDate, Date manufactureDate, String condition) {
		this.name = name;
		this.author = author;
		this.releaseDate = releaseDate;
		this.manufactureDate = manufactureDate;
		this.condition = condition;
	}

	public Album(int id, String name, Author author, Date releaseDate, Date manufactureDate, String condition) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.releaseDate = releaseDate;
		this.manufactureDate = manufactureDate;
		this.condition = condition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
