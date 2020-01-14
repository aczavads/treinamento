package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class ContaContabilFS2 extends BaseEntity {
	private String codigo;	
	private String nome;
	
	@ManyToOne
	private ContaContabilFS2 contaSuperior;
	
	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabilFS2> contasFilhas;
	
	public ContaContabilFS2() {
		super();
	}

	public ContaContabilFS2(String codigo, String nome, ContaContabilFS2 contaSuperior) {
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

	public ContaContabilFS2 getContaSuperior() {
		return contaSuperior;
	}
	
	public List<ContaContabilFS2> getContasFilhas() {
		return contasFilhas;
	}

	public void setContaSuperior(ContaContabilFS2 contaSuperior) {
		this.contaSuperior = contaSuperior;
	}
	
	public UUID getContaSuperiorId() {
		if (this.contaSuperior == null) {
			return null;
		}
		return this.contaSuperior.getId();
	}

	@Override
	public String toString() {
		return "ContaContabil [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior + ", getId()="
				+ getId() + "]";
	}
	
	
	

}
