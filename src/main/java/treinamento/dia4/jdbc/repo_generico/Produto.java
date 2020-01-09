package treinamento.dia4.jdbc.repo_generico;

import java.util.UUID;

public class Produto extends Entidade {
	@ChavePrimaria
	private UUID id;
	private String nome;
	
	public UUID getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
