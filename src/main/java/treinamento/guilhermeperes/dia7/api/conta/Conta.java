package treinamento.guilhermeperes.dia7.api.conta;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import treinamento.guilhermeperes.dia7.base.BaseEntity;

@Entity
public class Conta extends BaseEntity {
	
	private String nome;
	
	private int codigo;
	
	@ManyToOne
	private Conta contaSuperior;

	public Conta() {
		super();
	}

	public Conta(String nome, int codigo, Conta contaSuperior) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.contaSuperior = contaSuperior;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public Conta getContaSuperior() {
		return contaSuperior;
	}
}
