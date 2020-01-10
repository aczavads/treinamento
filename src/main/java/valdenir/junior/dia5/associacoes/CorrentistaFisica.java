package valdenir.junior.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import valdenir.junior.dia5.jpa.CPF;

@Entity
public class CorrentistaFisica extends Correntista {

	@Embedded
	@AttributeOverride(name = "valor", column = @Column(name = "cpf"))
	private CPF cpf;
	private LocalDate nascidaEm;

	public CorrentistaFisica() {
		super();
	}

	public CorrentistaFisica(CPF cpf, String nome, LocalDate nascidaEm) {
		this();
		this.cpf = cpf;
		this.nascidaEm = nascidaEm;
		this.setNome(nome);
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascidaEm() {
		return nascidaEm;
	}

	public void setNascidaEm(LocalDate nascidaEm) {
		this.nascidaEm = nascidaEm;
	}

}
