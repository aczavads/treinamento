package diegomucheniski.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import diegomucheniski.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class ContaContabil extends BaseEntity {
	
	private String codigo;
	private String nome;		
	
	@JsonIgnore
	@ManyToOne
	private ContaContabil contaSuperior;		
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	List<ContaContabil> contasFilhas = new ArrayList<>();
	
	public ContaContabil(String codigo, String nome, ContaContabil contaSuperior) {		
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;		
	}
		
	public List<ContaContabil> getContasFilhas() {
		return contasFilhas;
	}
	
	public Long getContaSuperiorId() {
		if (contaSuperior != null) {
			return this.contaSuperior.getId();
		}
		return null;
	}

}
