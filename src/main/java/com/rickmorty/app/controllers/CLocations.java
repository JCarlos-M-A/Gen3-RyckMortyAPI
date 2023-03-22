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

import com.rickmorty.app.dtos.LocationCreateDTO;
import com.rickmorty.app.dtos.LocationListDTO;
import com.rickmorty.app.services.IService;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "*")
public class CLocations {
	
	@Autowired
	private IService<LocationListDTO, LocationCreateDTO> locationService;
	

	@GetMapping
	public List<LocationListDTO> getListaLocations(){
		return locationService.getAll();
	}
	
	@PostMapping
	public LocationListDTO guardarLocation(@RequestBody LocationCreateDTO locationDTO) {
		return locationService.create(locationDTO);
	}
	
	@GetMapping("/{id}")
	public LocationListDTO getLocationById(@PathVariable(name = "id") long id) {
		return locationService.getById(id);
	}
	
	@PutMapping("/{id}")
	public LocationListDTO actualizarLocation(@RequestBody LocationCreateDTO locationDTO, 
			@PathVariable(name = "id") long id) {
		LocationListDTO locationRespuesta = locationService.update(locationDTO, id);
		return locationRespuesta;
	}
	
	@DeleteMapping("/{id123}")
	public Map<String, String> eliminarCharacter(@PathVariable(name="id123") long id) {
		Map<String, String> mapa = new HashMap<>();
		locationService.delete(id);
		mapa.put("message", "Location delete success");
		return mapa;
	}
}
