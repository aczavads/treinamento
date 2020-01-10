package thais.matera.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import treinamento.dia5.jpa.CPF;

@Entity
public class CorrentistaFisica extends Correntista {
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name="cpfdotitular"))
	private CPF cpf;
	
	@Column(nullable = false)
	private LocalDate nascidaEm;
	
	public CorrentistaFisica() {
		super();
	}
	
	public CorrentistaFisica(String nome, CPF cpf, LocalDate nascidaEm) {
		super(nome);
		this.cpf = cpf;
		this.nascidaEm = nascidaEm;
	}

	@Override
	public String toString() {
		return "CorrentistaFisica [cpf=" + cpf + ", nascidaEm=" + nascidaEm + "]";
	}

	public CPF getCpf() {
		return cpf;
	}

	public LocalDate getNascidaEm() {
		return nascidaEm;
	}

}
