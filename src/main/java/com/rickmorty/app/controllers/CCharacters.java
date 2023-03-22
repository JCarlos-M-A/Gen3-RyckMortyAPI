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

import com.rickmorty.app.dtos.CharacterCreateDTO;
import com.rickmorty.app.dtos.CharacterListDTO;
import com.rickmorty.app.services.IService;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "*")
public class CCharacters {
				
	@Autowired
	private IService<CharacterListDTO, CharacterCreateDTO> charactersService;
	

	@GetMapping
	public List<CharacterListDTO> getListaCharacters(){
		return charactersService.getAll();
	}
	
	@PostMapping
	public CharacterListDTO guardarCharacter(@RequestBody CharacterCreateDTO characterDTO) {
		return charactersService.create(characterDTO);
	}
	
	@GetMapping("/{id}")
	public CharacterListDTO getCharacterById(@PathVariable(name = "id") long id) {
		return charactersService.getById(id);
	}
	
	@PutMapping("/{id}")
	public CharacterListDTO actualizarCharacter(@RequestBody CharacterCreateDTO characterDTO, 
			@PathVariable(name = "id") long id) {
		CharacterListDTO characterRespuesta = charactersService.update(characterDTO, id);
		return characterRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarCharacter(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		charactersService.delete(id);
		mapa.put("message", "Character delete success");
		return mapa;
	}
		
}
