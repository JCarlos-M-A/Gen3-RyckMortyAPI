package com.rickmorty.app.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "characcters")
public class Character {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQCHAR")
	@SequenceGenerator(sequenceName = "character_seqchar", allocationSize = 1, name = "CUST_SEQCHAR")
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "specie")
	private String specie;
	
	@Column(name = "image")
	private String image;

	//columna locatio de tipo objeto
	@ManyToOne
	@JoinColumn(name = "Location_id")
	private Location location;
	
    @ManyToMany
    @JoinTable(
    		  name = "characters_episodes", 
    		  joinColumns = @JoinColumn(name = "character_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "episode_id"))
    Set<Episode> likedEpisodes;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Episode> getLikedEpisodes() {
		return likedEpisodes;
	}

	public void setLikedEpisodes(Set<Episode> likedEpisodes) {
		this.likedEpisodes = likedEpisodes;
	}
	
	
}
