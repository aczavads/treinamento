package giovani.bueno.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.Entity;

import giovani.bueno.jpa.CPF;

@Entity
public class CorrentistaFisica extends Correntista {

	private CPF CPF;
	private LocalDate nascidaEm;
	
	private CorrentistaFisica() {
		super();
	}
	
	public CorrentistaFisica(String nome, CPF cPF, LocalDate nascidaEm) {
		super();
		CPF = cPF;
		this.nascidaEm = nascidaEm;
		this.setNome(nome);
	}
	public CPF getCPF() {
		return CPF;
	}
	public void setCPF(CPF cPF) {
		CPF = cPF;
	}
	public LocalDate getNascidaEm() {
		return nascidaEm;
	}
	public void setNascidaEm(LocalDate nascidaEm) {
		this.nascidaEm = nascidaEm;
	}
	@Override
	public void setNome(String nome) {
		super.setNome(nome);
	}
	@Override
	public String toString() {
		return "CorrentistaFisica [CPF=" + CPF + ", nascidaEm=" + nascidaEm + "]";
	}
	
}
