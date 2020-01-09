package william.dia4.RepositoryGenerico;

import java.util.UUID;

public class Produto extends Entidade {
		
	public Produto(String nome) {
		super();
		this.nome = nome;
	}
	String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
