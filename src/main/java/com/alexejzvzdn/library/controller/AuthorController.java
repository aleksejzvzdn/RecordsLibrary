package com.alexejzvzdn.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexejzvzdn.library.entity.Author;
import com.alexejzvzdn.library.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/{id}")
	public String getAuthor(@PathVariable("id") int id, Model model) {
		Author author = authorService.findById(id);
		model.addAttribute("author", author);
		return "/authors/author";
	}
}
