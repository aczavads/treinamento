package treinamento.diegomucheniski.domains;

import java.util.UUID;

import treinamento.diegomucheniski.annotations.ChavePrimaria;

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
