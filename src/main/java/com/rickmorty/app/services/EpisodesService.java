package com.rickmorty.app.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rickmorty.app.dao.ICharactersDao;
import com.rickmorty.app.dao.IEpisodesDao;
import com.rickmorty.app.dtos.EpisodeCreateDTO;
import com.rickmorty.app.dtos.EpisodeListDTO;
import com.rickmorty.app.dtos.EpisodioDto;
import com.rickmorty.app.dtos.PersonajeDto;
import com.rickmorty.app.models.Character;
import com.rickmorty.app.models.Episode;
import com.rickmorty.app.models.Location;

@Component
public class EpisodesService implements IService<EpisodeListDTO, EpisodeCreateDTO>{
	
	@Autowired
	private IEpisodesDao episodesDao;
	
	@Autowired
	private ICharactersDao charactersDao;

	@Override
	public EpisodeListDTO create(EpisodeCreateDTO obj) {
		Episode episode = this.dtoToEntity(obj);
		Episode episodeNueva = episodesDao.save(episode);
		return this.entityToDto(episodeNueva);
	}

	@Override
	public List<EpisodeListDTO> getAll() {
		List<EpisodeListDTO> listaDTO = new ArrayList<>();
		List<Episode> lista = episodesDao.findAll();
		for (Episode episode : lista) {
			listaDTO.add(this.entityToDto(episode));
		}
		return listaDTO;
	}

	@Override
	public EpisodeListDTO getById(long id) {
		Episode episode = episodesDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(episode);
	}

	@Override
	public EpisodeListDTO update(EpisodeCreateDTO obj, long id) {
		Episode episode = episodesDao.findById(id).orElseThrow(() -> new RuntimeException());
		episode.setId(obj.getId());
		episode.setName(obj.getName());
		episode.setAir_date(obj.getAir_date());
		episode.setEpisode(obj.getEpisode());
		
		Episode episodeActual = episodesDao.save(episode);
		return this.entityToDto(episodeActual);
	}

	@Override
	public void delete(long id) {
		Optional<Episode> episode = episodesDao.findById(id);
		if(episode.isPresent()) {
			episodesDao.delete(episode.get());
		}else {
			
		}
	}
	
	public Episode dtoToEntity(EpisodeCreateDTO episodeDto) {
		Episode episode = new Episode();
		episode.setId(episodeDto.getId());
		episode.setName(episodeDto.getName());
		episode.setAir_date(episodeDto.getAir_date());
		episode.setEpisode(episodeDto.getEpisode());
		
		return episode;	
	}
	
	public EpisodeListDTO entityToDto(Episode episode) {
		EpisodeListDTO episodeDto = new EpisodeListDTO();
		episodeDto.setId(episode.getId());
		episodeDto.setName(episode.getName());
		episodeDto.setAir_date(episode.getAir_date());
		episodeDto.setEpisode(episode.getEpisode());
		if(episode.getLikedCharacters()!=null) {
			List<PersonajeDto> personajes = new ArrayList<>();
			for (Character personaje : episode.getLikedCharacters()) {
				PersonajeDto perso = new PersonajeDto();
				perso.setId(personaje.getId());
				perso.setName(personaje.getName());
				perso.setImage(personaje.getImage());
				perso.setStatus(personaje.getStatus());
				perso.setSpecie(personaje.getSpecie());
				perso.setLocation(personaje.getLocation());
				personajes.add(perso);
			}	
			episodeDto.setCharacters(personajes);
		}
		
		return episodeDto;
	}
	
}
