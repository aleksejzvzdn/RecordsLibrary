package com.alexejzvzdn.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexejzvzdn.library.dao.AuthorRepository;
import com.alexejzvzdn.library.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author findById(int id) {
		Optional<Author> result = authorRepository.findById(id);
		Author author = null;
		if (result.isPresent()) {
			author = result.get();
		} else {
			throw new RuntimeException("Didn't find author id " + id);
		}
		return author;
	}

	@Override
	public void save(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void deleteById(int id) {
		authorRepository.deleteById(id);
	}

	@Override
	public Author findByName(String name) {
		Optional<Author> result = authorRepository.findByNameIgnoreCase(name);
		Author author = null;
		if (result.isPresent()) {
			author = result.get();
		} else {
			throw new RuntimeException("Didn't find author" + name); 
		}
		return author;
	}
}
