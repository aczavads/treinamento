package treinamento.dia7.conta_contabil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class ContaContabil extends BaseEntity {
	private String codigo;
	private String nome;
	
	@ManyToOne
	private ContaContabil contaSuperior;
	
	public ContaContabil() {
		super();
	}

	public ContaContabil(String codigo, String nome, ContaContabil contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ContaContabil getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabil contaSuperior) {
		this.contaSuperior = contaSuperior;
	}

	@Override
	public String toString() {
		return "ContaContabil [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior + ", getId()="
				+ getId() + "]";
	}
	
	
	

}
