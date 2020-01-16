package guscam.dia6.Livro;

import javax.persistence.Entity;

import guscam.dia7.BaseEntity;

@Entity
public class Livro2 extends BaseEntity {
	private String  nome;
	
	public Livro2() {
		super();
	}
	public Livro2(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Livro2 [nome=" + nome + "]";
	}
	
	
}
