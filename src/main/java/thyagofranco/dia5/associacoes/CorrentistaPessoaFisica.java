package thyagofranco.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import thyagofranco.dia5.CPF;
@Entity
public class CorrentistaPessoaFisica extends Correntista {
	
	@Embedded // Inteiro positivo
	@Column(unique = true, nullable = false)
	private CPF cpf;
	private LocalDate nascidaEm;
	
	public CorrentistaPessoaFisica() {
		super();
	}

	public CorrentistaPessoaFisica(CPF cpf, LocalDate nascidaEm, String nome) {
		super(nome);  // ou setNome(nome);
		this.cpf = cpf;
		this.nascidaEm = nascidaEm;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorrentistaPessoaFisica [cpf=");
		builder.append(cpf);
		builder.append(", nascidaEm=");
		builder.append(nascidaEm);
		builder.append(", nome=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
