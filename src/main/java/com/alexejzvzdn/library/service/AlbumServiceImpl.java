package com.alexejzvzdn.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexejzvzdn.library.dao.AlbumRepository;
import com.alexejzvzdn.library.entity.Album;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;
	
	@Autowired
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
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
		albumRepository.save(album);
	}

	@Override
	public void deleteById(int id) {
		albumRepository.deleteById(id);
	}

}
