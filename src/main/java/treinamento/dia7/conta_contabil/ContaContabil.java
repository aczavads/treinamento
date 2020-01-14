package treinamento.dia7.conta_contabil;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class ContaContabil extends BaseEntity {
	private String codigo;	
	private String nome;
	
	@ManyToOne
	private ContaContabil contaSuperior;
	
	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabil> contasFilhas;
	
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
	
	public List<ContaContabil> getContasFilhas() {
		return contasFilhas;
	}

	public void setContaSuperior(ContaContabil contaSuperior) {
		if(this.contaSuperior != null) {
			this.contaSuperior = contaSuperior;
		}
		
		this.contaSuperior = null;
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
