package com.rickmorty.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rickmorty.app.dao.ILocationsDao;
import com.rickmorty.app.dtos.LocationCreateDTO;
import com.rickmorty.app.dtos.LocationListDTO;
import com.rickmorty.app.models.Location;

@Component
public class LocationsService  implements IService<LocationListDTO, LocationCreateDTO>{
 
	@Autowired
	private ILocationsDao locationsDao;

	@Override
	public LocationListDTO create(LocationCreateDTO obj) {
		Location location = this.dtoToEntity(obj);
		Location locationNueva = locationsDao.save(location);
		return this.entityToDto(locationNueva);
	}

	@Override
	public List<LocationListDTO> getAll() {
		List<LocationListDTO> listaDTO = new ArrayList<>();
		List<Location> lista = locationsDao.findAll();
		for (Location location : lista) {
			listaDTO.add(this.entityToDto(location));
		}
		return listaDTO;
	}

	@Override
	public LocationListDTO getById(long id) {
		Location location = locationsDao.findById(id).orElseThrow(() -> new RuntimeException());
		return this.entityToDto(location);
	}

	@Override
	public LocationListDTO update(LocationCreateDTO obj, long id) {
		Location location = locationsDao.findById(id).orElseThrow(() -> new RuntimeException());
		location.setId(obj.getId());
		location.setDimension(obj.getDimension());
		location.setName(obj.getName());
		location.setType(obj.getType());
		
		Location locationActual = locationsDao.save(location);
		return this.entityToDto(locationActual);
	}

	@Override
	public void delete(long id) {
		Optional<Location> location = locationsDao.findById(id);
		if(location.isPresent()) {
			locationsDao.delete(location.get());
		}else {
			
		}
	}
	
	public Location dtoToEntity(LocationCreateDTO locationDto) {
		Location location = new Location();
		location.setId(locationDto.getId());
		location.setName(locationDto.getName());
		location.setDimension(locationDto.getDimension());
		location.setType(locationDto.getType());
		
		return location;	
	}
	
	public LocationListDTO entityToDto(Location location) {
		LocationListDTO locationaDto = new LocationListDTO();
		locationaDto.setId(location.getId());
		locationaDto.setName(location.getName());
		locationaDto.setDimension(location.getDimension());
		locationaDto.setType(location.getType());
		
		return locationaDto;
	}

}
