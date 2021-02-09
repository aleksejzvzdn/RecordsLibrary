package com.alexejzvzdn.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexejzvzdn.library.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
