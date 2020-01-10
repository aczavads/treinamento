package treinamento.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import treinamento.dia5.jpa.CPF;

//@Entity
public class CorrentistaFisica extends Correntista {
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name="cpf"))
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
	public CPF getCpf() {
		return cpf;
	}
	public LocalDate getNascidaEm() {
		return nascidaEm;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	public void setNascidaEm(LocalDate nascidaEm) {
		this.nascidaEm = nascidaEm;
	}

	@Override
	public String toString() {
		return "CorrentistaFisica [cpf=" + cpf + ", nascidaEm=" + nascidaEm + ", getNome()=" + getNome() + "]";
	}

}
