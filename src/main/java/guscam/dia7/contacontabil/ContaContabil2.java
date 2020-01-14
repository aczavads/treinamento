package guscam.dia7.contacontabil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class ContaContabil2 extends BaseEntity {
	private String codigo;
	private String nome;

	@ManyToOne
	private ContaContabil2 contaSuperior;

	public ContaContabil2() {
		super();
	}

	public ContaContabil2(String codigo, String nome, ContaContabil2 contaSuperior) {
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

	public ContaContabil2 getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabil2 contaSuperior) {
		this.contaSuperior = contaSuperior;
	}

	@Override
	public String toString() {
		return "ContaContabil2 [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior + "]";
	}
}
