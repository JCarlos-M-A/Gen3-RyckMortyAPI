package com.rickmorty.app.dtos;

public class CharacterCreateDTO {
	
	private Long id;
	private String name;
	private Boolean status;
	private String specie;
	private Long episode;
	private Long location;
	private String image;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getEpisode() {
		return episode;
	}
	public void setEpisode(Long episode) {
		this.episode = episode;
	}
	public Long getLocation() {
		return location;
	}
	public void setLocation(Long location) {
		this.location = location;
	}
	
}
