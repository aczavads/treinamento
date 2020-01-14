package treinamento.dia7.conta_contabil;

import javax.persistence.Entity;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class ContaContabil extends BaseEntity {
	private String codigo;
	private String nome;
	
	private ContaContabil contaSuperior;

}
