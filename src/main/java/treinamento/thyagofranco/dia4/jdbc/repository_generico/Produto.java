package treinamento.thyagofranco.dia4.jdbc.repository_generico;

import java.util.UUID;

public class Produto extends Entidade {
	@ChavePrimaria
	private UUID id;
	private String nome;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
