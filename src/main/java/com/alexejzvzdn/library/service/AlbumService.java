package com.alexejzvzdn.library.service;

import java.util.List;

import com.alexejzvzdn.library.entity.Album;

public interface AlbumService {
	
	public List<Album> findAll();
	
	public Album findById(int id);
	
	public void save(Album album);
	
	public void deleteById(int id);
}
