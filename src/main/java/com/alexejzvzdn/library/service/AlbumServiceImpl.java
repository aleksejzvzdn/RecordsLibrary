package com.alexejzvzdn.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexejzvzdn.library.dao.AlbumRepository;
import com.alexejzvzdn.library.dao.AuthorRepository;
import com.alexejzvzdn.library.entity.Album;
import com.alexejzvzdn.library.entity.Author;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public AlbumServiceImpl(AlbumRepository albumRepository, AuthorRepository authorRepository) {
		this.albumRepository = albumRepository;
		this.authorRepository = authorRepository;
	}

	@Override
	public List<Album> findAll() {
		return albumRepository.findAll();
	}

	@Override
	public Album findById(int id) {
		Optional<Album> result = albumRepository.findById(id);
		Album album = null;
		if (result.isPresent()) {
			album = result.get();
		} else {
			throw new RuntimeException("Didn't find album id " + id);
		}
		return album;
	}

	@Override
	public void save(Album album) {
		Optional<Author> resultAuthor = authorRepository.findByNameIgnoreCase(album.getAuthor().getName());
		Author author = null;
		if (resultAuthor.isPresent()) {
			author = resultAuthor.get();
			List<Album> list = author.getAlbums();
			list.add(album);
			author.setAlbums(list);
			album.setAuthor(author);
		}
		albumRepository.save(album);
	}

	@Override
	public void deleteById(int id) {
		albumRepository.deleteById(id);
	}

}
