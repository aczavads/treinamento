package GLF.dia4.jdbc.repo_generico;

import java.util.UUID;

public class Produto {
	
	@ChavePrimaria
	private UUID id;
	private String nome;
	
	public Produto(String nome) {
		super();
		this.nome = nome;
		
	}
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
