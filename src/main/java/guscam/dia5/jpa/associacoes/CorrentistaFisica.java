package guscam.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import guscam.dia5.jpa.Cpf;

@Entity
public class CorrentistaFisica extends Correntista {
	
	@Embedded
	@Column(unique = true, nullable = false)
	private Cpf cpf;

	private LocalDate dataDeNascimento;

	public CorrentistaFisica() {
		super();
	}
	public CorrentistaFisica(String nome, Cpf cpf, LocalDate dataDeNascimento) {
		super(nome);
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	public Cpf getCpf() {
		return cpf;
	}
	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
}
