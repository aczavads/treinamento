package treinamento.guilhermeperes.dia7.api.conta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import treinamento.guilhermeperes.dia7.base.BaseEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Conta extends BaseEntity {
	
	@NotBlank
	private String nome;
	
	@Column(unique = true)
	private int codigo;
	
	@ManyToOne
	private Conta contaSuperior;
}
