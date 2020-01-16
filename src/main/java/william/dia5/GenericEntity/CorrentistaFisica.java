package william.dia5.GenericEntity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import william.dia5.CPF;

@Entity
public class CorrentistaFisica extends Correntista{
	@Column(unique=true, nullable = false)
	private CPF cpf;
	private LocalDate dataNascimento;
	

	public CorrentistaFisica(CPF cpf, LocalDate dataNascimento, String nome) {
		super(nome);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public CPF getCpf() {
		return cpf;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "CorrentistaFisica [cpf=" + cpf + ", dataNascimento=" + dataNascimento + "]"+ getContas().size();
	}
	
	
}
