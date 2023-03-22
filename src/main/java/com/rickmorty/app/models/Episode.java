package com.rickmorty.app.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "episodes")
public class Episode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQEPI")
	@SequenceGenerator(sequenceName = "episode_seqcepi", allocationSize = 1, name = "CUST_SEQEPI")
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "air_date")
	private Date air_date;
	
	@Column(name = "episode")
	private String episode;
	
	@ManyToMany(mappedBy = "likedEpisodes")
	Set<Character> likedCharacters;

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

	public Set<Character> getLikedCharacters() {
		return likedCharacters;
	}

	public void setLikedCharacters(Set<Character> likedCharacters) {
		this.likedCharacters = likedCharacters;
	}
	
	

}
