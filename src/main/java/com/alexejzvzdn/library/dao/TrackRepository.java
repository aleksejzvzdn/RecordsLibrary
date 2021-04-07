package com.alexejzvzdn.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexejzvzdn.library.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {

}
