package schiavon.gabriel.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Correntista {

	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "cpf"))
	private CPF cpf;
	
	@Column
	private LocalDate nascidoEm;

	private PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, CPF cpf, LocalDate nascidoEm) {
		super(nome);
		this.cpf = cpf;
		this.nascidoEm = nascidoEm;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascidoEm() {
		return nascidoEm;
	}

	public void setNascidoEm(LocalDate nascidoEm) {
		this.nascidoEm = nascidoEm;
	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", nascidoEm=" + nascidoEm + "]";
	}
}
