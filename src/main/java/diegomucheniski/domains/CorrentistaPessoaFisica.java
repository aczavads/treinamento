package diegomucheniski.domains;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

// @Entity
public class CorrentistaPessoaFisica extends Correntista {
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "cpf", column = @Column(name = "cpf"))
	private CPFValido cpf;
	
	private LocalDate nascidoEm;
	
	public CorrentistaPessoaFisica() {
		super();
	}

	public CorrentistaPessoaFisica(CPFValido cpf, LocalDate nascidoEm, String nome) {
		super(nome);
		this.cpf = cpf;
		this.nascidoEm = nascidoEm;
	}

	public CPFValido getCpf() {
		return cpf;
	}

	public void setCpf(CPFValido cpf) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("CorrentistaPessoaFisica [cpf=");
		builder.append(cpf);
		builder.append(", nascidoEm=");
		builder.append(nascidoEm);
		builder.append(", Nome=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();
	}
	
}
