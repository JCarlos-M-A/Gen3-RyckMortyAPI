package com.rickmorty.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharactersDao extends JpaRepository<com.rickmorty.app.models.Character, Long>{

}
