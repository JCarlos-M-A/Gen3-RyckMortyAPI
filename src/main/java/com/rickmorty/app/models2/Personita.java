package com.rickmorty.app.models2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personitas")
public class Personita {

	@Id
	Long id;
	String appp;
}
