package com.rickmorty.app.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rickmorty.app.dao.ICharactersDao;
import com.rickmorty.app.dao.IEpisodesDao;
import com.rickmorty.app.dao.ILocationsDao;
import com.rickmorty.app.dtos.CharacterCreateDTO;
import com.rickmorty.app.dtos.CharacterListDTO;
import com.rickmorty.app.dtos.EpisodeListDTO;
import com.rickmorty.app.dtos.EpisodioDto;
import com.rickmorty.app.models.Character;
import com.rickmorty.app.models.Episode;
import com.rickmorty.app.models.Location;

@Component
public class CharactersService implements IService<CharacterListDTO, CharacterCreateDTO> {
	
	@Autowired
	private ICharactersDao charactersDao;
	
	@Autowired
	private ILocationsDao locationsDao;
	
	@Autowired
	private IEpisodesDao episodesDao;

	@Override
	public CharacterListDTO create(CharacterCreateDTO obj) {
		com.rickmorty.app.models.Character character = this.dtoToEntity(obj);
		com.rickmorty.app.models.Character characterNuevo = charactersDao.save(character);
		return this.entityToDto(characterNuevo);
	}

	@Override
	public List<CharacterListDTO> getAll() {
		List<CharacterListDTO> listaDTO = new ArrayList<>();
		List<com.rickmorty.app.models.Character> lista = charactersDao.findAll();
		for (com.rickmorty.app.models.Character character : lista) {
			listaDTO.add(this.entityToDto(character));
		}
		return listaDTO;
	}

	@Override
	public CharacterListDTO getById(long id) {
		com.rickmorty.app.models.Character character = charactersDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(character);
	}

	@Override
	public CharacterListDTO update(CharacterCreateDTO obj, long id) {
		com.rickmorty.app.models.Character characters = charactersDao.findById(id).orElseThrow(() -> new RuntimeException());
		characters.setId(characters.getId());
		characters.setName(characters.getName());
		characters.setImage(characters.getImage());
		characters.setSpecie(characters.getSpecie());
		characters.setStatus(characters.getStatus());
		characters.setLocation(characters.getLocation());
		characters.setLikedEpisodes(characters.getLikedEpisodes());
		
		com.rickmorty.app.models.Character characterActual = charactersDao.save(characters);
		return this.entityToDto(characterActual);
	}

	@Override
	public void delete(long id) {
		Optional<com.rickmorty.app.models.Character> character = charactersDao.findById(id);
		if(character.isPresent()) {
			charactersDao.delete(character.get());
		}else {
			
		}
	}
	
	public com.rickmorty.app.models.Character dtoToEntity(CharacterCreateDTO characterDTO) {
		com.rickmorty.app.models.Character character = new com.rickmorty.app.models.Character();
		character.setId(characterDTO.getId());
		character.setName(characterDTO.getName());
		character.setImage(characterDTO.getImage());
		character.setSpecie(characterDTO.getSpecie());
		character.setStatus(characterDTO.getStatus());
		
		Optional<Location> location = locationsDao.findById(characterDTO.getLocation());
		if(location.isPresent()) {
			character.setLocation(location.get());
		}else {
			
		}
		
		Set<Episode> targetSet = new HashSet<>();
		Optional<Episode> episode = episodesDao.findById(characterDTO.getEpisode());
		if(episode.isPresent()) {
			//character.setLocation(location.get());
			 targetSet.add(episode.get());
		}else {
			
		}
		
		character.setLikedEpisodes(targetSet);
		
		//FALTA GUARDAR EL PEROSNAJE
		//episodesDao.save(characterDTO);
		
		//
		return character;	
	}
	
	public CharacterListDTO entityToDto(com.rickmorty.app.models.Character character) {
		CharacterListDTO characterDto = new CharacterListDTO();
		if(character!=null) {
			characterDto.setId(character.getId());
			characterDto.setImage(character.getImage());
			characterDto.setName(character.getName());
			characterDto.setSpecie(character.getSpecie());
			characterDto.setStatus(character.getStatus());	
			if(character.getLocation()!=null) {
				Optional<Location> location = locationsDao.findById(character.getLocation().getId());
				if(location.isPresent()) {
					characterDto.setLocation(location.get());
				}else {
					
				}
				
			}

			List<EpisodioDto> episodes = new ArrayList<>();
			for (Episode episodio : character.getLikedEpisodes()) {
				EpisodioDto episo = new EpisodioDto();
				episo.setId(episodio.getId());
				episo.setName(episodio.getName());
				episo.setAir_date(episodio.getAir_date());
				episo.setEpisode(episodio.getEpisode());
				episodes.add(episo);
			}
			characterDto.setEpisodes(episodes);
		}
		
		return characterDto;
	}

}
