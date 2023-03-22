package com.rickmorty.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickmorty.app.models.Episode;

public interface IEpisodesDao extends JpaRepository<Episode, Long>{

}
