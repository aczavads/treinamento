package guscam.dia7.contacontabil;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class ContaContabil2 extends BaseEntity {
	private String codigo;
	private String nome;

	@ManyToOne
	private ContaContabil2 contaSuperior;

	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabil2> contasFilhas;
	
	public ContaContabil2() {
		super();
	}

	public ContaContabil2(UUID id, String codigo, String nome, ContaContabil2 contaSuperior) {
		super(id);
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
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

	@JsonIgnore
	public ContaContabil2 getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabil2 contaSuperior) {
		this.contaSuperior = contaSuperior;
	}

	@JsonIgnore
	public List<ContaContabil2> getContasFilhas() {
		return contasFilhas;
	}

	public void setContasFilhas(List<ContaContabil2> contasFilhas) {
		this.contasFilhas = contasFilhas;
	}

	@Override
	public String toString() {
		return "ContaContabil2 [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior + "]";
	}
}
