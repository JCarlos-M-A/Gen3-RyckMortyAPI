package com.rickmorty.app.dtos;

import java.util.Date;

public class EpisodioDto {

	private Long id;
	private String name;
	private Date air_date;
	private String episode;
	
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
	public Date getAir_date() {
		return air_date;
	}
	public void setAir_date(Date air_date) {
		this.air_date = air_date;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
}
