package diegomucheniski.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContaContabil extends BaseEntity {
	
	private String codigo;
	private String nome;		
	
	@JsonIgnore
	@ManyToOne
	private ContaContabil contaSuperior;		
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	List<ContaContabil> contasFilhas = new ArrayList<>();
	
	public ContaContabil() {
		super();
	}

	public ContaContabil(String codigo, String nome, ContaContabil contaSuperior) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}
	
	public ContaContabil(UUID id, String codigo, String nome, ContaContabil contaSuperior) {
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

	public ContaContabil getContaSuperior() {
		return contaSuperior;
	}

	public void setContaSuperior(ContaContabil contaSuperior) {
		this.contaSuperior = contaSuperior;
	}
	
	public List<ContaContabil> getContasFilhas() {
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
