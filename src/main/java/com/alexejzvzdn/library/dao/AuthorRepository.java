package com.alexejzvzdn.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexejzvzdn.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
