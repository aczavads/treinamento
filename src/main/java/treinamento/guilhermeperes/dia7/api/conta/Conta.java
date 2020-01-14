package treinamento.guilhermeperes.dia7.api.conta;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import treinamento.guilhermeperes.dia7.base.BaseEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Conta extends BaseEntity {
	
	private String nome;
	
	private int codigo;
	
	@ManyToOne
	private Conta contaSuperior;
}
