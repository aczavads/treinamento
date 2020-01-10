package treinamento.thyagofranco.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import treinamento.thyagofranco.dia5.CPF;

@Entity
public class CorrentistaPessoaJuridica extends Correntista {
	
	@Embedded // Inteiro positivo
	@Column(unique = true, nullable = false)
	private CNPJ cnpj;
	
	private String razaoSocial;
	private LocalDate fundadaEm;
	
	public CorrentistaPessoaJuridica() {
		super();
	}

	public CorrentistaPessoaJuridica(CNPJ cnpj, String razaoSocial, LocalDate fundadaEm, String nome) {
		super(nome);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
	}

	public CNPJ getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public LocalDate getFundadaEm() {
		return fundadaEm;
	}

	public void setFundadaEm(LocalDate fundadaEm) {
		this.fundadaEm = fundadaEm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorrentistaPessoaJuridica [cnpj=");
		builder.append(cnpj);
		builder.append(", razaoSocial=");
		builder.append(razaoSocial);
		builder.append(", fundadaEm=");
		builder.append(fundadaEm);
		builder.append(", Nome()=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
