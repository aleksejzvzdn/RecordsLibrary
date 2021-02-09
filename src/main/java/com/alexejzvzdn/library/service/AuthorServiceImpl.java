package com.alexejzvzdn.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexejzvzdn.library.dao.AuthorRepository;
import com.alexejzvzdn.library.entity.Author;

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

}
