package treinamento.diegomucheniski.dia7.conta_contabil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import treinamento.diegomucheniski.domains.BaseEntity;

@Entity
public class ContaContabilMucheniski extends BaseEntity {
	
	private String codigo;
	private String nome;		
	
	@JsonIgnore
	@ManyToOne
	private ContaContabilMucheniski contaSuperior;		
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	List<ContaContabilMucheniski> contasFilhas = new ArrayList<>();
	
	public ContaContabilMucheniski() {
		super();
	}

	public ContaContabilMucheniski(String codigo, String nome, ContaContabilMucheniski contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}
	
	public ContaContabilMucheniski(UUID id, String codigo, String nome, ContaContabilMucheniski contaSuperior) {
		super(id);
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}
	
	public UUID getContaSuperiorId() {
		if (this.contaSuperior != null) {
			return contaSuperior.getId();
		}
		return null;
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

	public ContaContabilMucheniski getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabilMucheniski contaSuperior) {
		this.contaSuperior = contaSuperior;
	}
	
	public List<ContaContabilMucheniski> getContasFilhas() {
		return contasFilhas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaContabilMucheniski [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", contaSuperior=");
		builder.append(contaSuperior);
		builder.append("]");
		return builder.toString();
	}	

}
