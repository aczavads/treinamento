package treinamento.thyagofranco.dia7.conta_contabil;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import treinamento.thyagofranco.dia5.associacoes.BaseEntity;

@Entity
public class ContaContabilThyago extends BaseEntity {
	private String codigo;
	private String nome;

	@JsonIgnore
	@ManyToOne
	private ContaContabilThyago contaSuperior;

	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior", fetch = FetchType.LAZY)
	private List<ContaContabilThyago> contasFilhas;

	public ContaContabilThyago() {
		super();
	}

	public ContaContabilThyago(String codigo, String nome, ContaContabilThyago contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}

	public ContaContabilThyago(UUID id, String codigo, String nome, ContaContabilThyago contaSuperior) {
		super(id);
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}

	public List<ContaContabilThyago> getContasFilhas() {
		return contasFilhas;
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

	public ContaContabilThyago getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabilThyago contaSuperior) {
		this.contaSuperior = contaSuperior;
	}
	
	public UUID getContaSuperiorID() {
		if(this.contaSuperior != null) {
			return this.contaSuperior.getId();
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaContabilThyago [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", contaSuperior=");
		builder.append(contaSuperior);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append("]");
		return builder.toString();
	}

}
