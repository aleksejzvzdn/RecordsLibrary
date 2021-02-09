package com.alexejzvzdn.library.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexejzvzdn.library.entity.Album;
import com.alexejzvzdn.library.service.AlbumService;

@Controller
@RequestMapping("/albums")
public class AlbumController {
	
	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	@GetMapping("/list")
	public String listAlbums(Model model) {
		List<Album> albums = albumService.findAll();
		model.addAttribute("albums", albums);
		return "/albums/list-albums";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Album album = new Album();
		model.addAttribute("album", album);
		return "/albums/album-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Album album = albumService.findById(id);
		model.addAttribute("album", album);
		return "/albums/album-form";
	}
	
	@PostMapping("/save")
	public String saveAlbum(@ModelAttribute("album") Album album) {
		albumService.save(album);
		return "redirect:/albums/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		albumService.deleteById(id);
		return "redirect:/albums/list";
	}
}
