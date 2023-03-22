package com.rickmorty.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickmorty.app.models.Location;

public interface ILocationsDao extends JpaRepository<Location, Long>{

}
