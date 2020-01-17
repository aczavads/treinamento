package treinamento.dia10.conta_contabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import treinamento.dia10.base.BaseEntity;
import treinamento.dia10.movimento_conta_contabil.MovimentoContaContabil;



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

	
	@JsonIgnore
	@OneToMany(mappedBy = "contaContabil")
	private List<MovimentoContaContabil> movimentos;
	
		
	public Long getContaSuperiorId() {
		if (this.contaSuperior != null) {
			return this.contaSuperior.getId();
		} 
		return null;
	}



}
