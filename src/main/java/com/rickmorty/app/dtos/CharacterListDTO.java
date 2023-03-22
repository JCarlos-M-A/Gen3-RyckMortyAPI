package com.rickmorty.app.dtos;

import java.util.ArrayList;
import java.util.List;

import com.rickmorty.app.models.Episode;
import com.rickmorty.app.models.Location;

public class CharacterListDTO {

	private Long id;
	private String name;
	private String image;
	private Boolean status;
	private String specie;
	private Location location = new Location();
	private List<EpisodioDto> episodes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<EpisodioDto> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<EpisodioDto> episodes) {
		this.episodes = episodes;
	}
}
