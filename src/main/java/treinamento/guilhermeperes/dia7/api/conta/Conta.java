package treinamento.guilhermeperes.dia7.api.conta;

import javax.persistence.Entity;

import treinamento.guilhermeperes.dia7.base.BaseEntity;

@Entity
public class Conta extends BaseEntity {
	
	private String nome;

	public Conta() {
		super();
	}

	public Conta(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
