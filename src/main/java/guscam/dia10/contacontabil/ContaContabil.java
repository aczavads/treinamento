package guscam.dia10.contacontabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import guscam.dia10.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ContaContabil extends BaseEntity {
	private String codigo;	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	private ContaContabil contaSuperior;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabil> contasFilhas;
	
	public Long getContaSuperiorId() {
		return this.contaSuperior != null ? this.contaSuperior.getId() : null;
	}
}
