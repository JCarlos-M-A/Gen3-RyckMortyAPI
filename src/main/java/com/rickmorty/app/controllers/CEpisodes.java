package com.rickmorty.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickmorty.app.dtos.EpisodeCreateDTO;
import com.rickmorty.app.dtos.EpisodeListDTO;
import com.rickmorty.app.services.IService;

@RestController
@RequestMapping("/api/episodes")
@CrossOrigin(origins = "*")
public class CEpisodes {
	@Autowired
	private IService<EpisodeListDTO, EpisodeCreateDTO> episodesService;
	

	@GetMapping
	public List<EpisodeListDTO> getListaEpisodes(){
		return episodesService.getAll();
	}
	
	@PostMapping
	public EpisodeListDTO guardarEpisode(@RequestBody EpisodeCreateDTO episodeDTO) {
		return episodesService.create(episodeDTO);
	}
	
	@GetMapping("/{id}")
	public EpisodeListDTO getCharacterById(@PathVariable(name = "id") long id) {
		return episodesService.getById(id);
	}
	
	@PutMapping("/{id}")
	public EpisodeListDTO actualizarEpisode(@RequestBody EpisodeCreateDTO episodeDTO, 
			@PathVariable(name = "id") long id) {
		EpisodeListDTO episodeRespuesta = episodesService.update(episodeDTO, id);
		return episodeRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarEpisode(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		episodesService.delete(id);
		mapa.put("message", "Episode delete success");
		return mapa;
	}
}
