package diegomucheniski.domains;

import java.util.UUID;

import diegomucheniski.annotations.ChavePrimaria;

public class Entidade {

	@ChavePrimaria
	private UUID id;
	
	public Entidade() {
		this.id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
	
}
