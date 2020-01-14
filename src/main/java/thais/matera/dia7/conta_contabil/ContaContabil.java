package thais.matera.dia7.conta_contabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import thais.matera.dia5.associacoes.BaseEntity;

@Entity
public class ContaContabil extends BaseEntity {
	private String codigo;
	private String nome;
	
	@ManyToOne
	private ContaContabil contaSuperior;
	
//	@OneToMany(mappedBy = "contaSuperior")
//	private List<ContaContabil> contasFilhas;

	public ContaContabil() {
		super();
	}
	
	public ContaContabil(String codigo, String nome, ContaContabil contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}

//	public List<ContaContabil> getContasFilhos() {
//		return contasFilhas;
//	}
//	
//	public void setContasFilhos(List<ContaContabil> contasFilhos) {
//		this.contasFilhas = contasFilhos;
//	}

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

	@Override
	public String toString() {
		return "ContaContabil [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior + "]";
	}

	public ContaContabil getContaSuperior() {
		return contaSuperior;
	}

	@JsonIgnore
	public void setContaSuperior(ContaContabil contaSuperior) {
		this.contaSuperior = contaSuperior;
	}
	
}
