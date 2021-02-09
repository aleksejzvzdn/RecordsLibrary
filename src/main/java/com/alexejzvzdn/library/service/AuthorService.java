package com.alexejzvzdn.library.service;

import java.util.List;

import com.alexejzvzdn.library.entity.Author;

public interface AuthorService {
	
	public List<Author> findAll();
	
	public Author findById(int id);
	
	public void save(Author author);
	
	public void deleteById(int id);
}
