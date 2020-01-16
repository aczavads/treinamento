package fernando_santos.treinamento.dia7.conta_contabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fernando_santos.treinamento.dia5.jpa.associacao.BaseEntity;

@Entity
public class ContaContabilFS extends BaseEntity {
	private String codigo;
	private String nome;

	@ManyToOne
	private ContaContabilFS contaSuperior;

	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabilFS> contasFilhas;

	public ContaContabilFS() {
	}

	public ContaContabilFS(String codigo, String nome, ContaContabilFS contaSuperior) {
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
	public ContaContabilFS getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabilFS contaSuperior) {
		this.contaSuperior = contaSuperior;
	}

	public List<ContaContabilFS> getContasFilhas() {
		return contasFilhas;
	}

	public void setContasFilhas(List<ContaContabilFS> contasFilhas) {
		this.contasFilhas = contasFilhas;
	}

}
