package william.dia7.Conta_Contabilwd;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import william.dia5.GenericEntity.BaseEntity;



@Entity
public class ContaContabil extends BaseEntity {
	private String codigo;
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	private ContaContabil contaSuperior;
	
	@OneToMany(mappedBy = "contaSuperior", fetch = FetchType.LAZY)
	private List<ContaContabil> contasFilhas;

	public ContaContabil(String codigo, String nome, ContaContabil contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}

	public ContaContabil() {
		super();
	}
	

	public List<ContaContabil> getContasFilhas() {
		return contasFilhas;
	}

	public void setContasFilhas(List<ContaContabil> contasFilhas) {
		this.contasFilhas = contasFilhas;
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
		return "ContaContabil [codigo=" + codigo + ", nome=" + nome + ", contaSuperior=" + contaSuperior + "]";
	}
	
	

}
