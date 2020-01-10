package treinamento.diegomucheniski.domains;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class CorrentistaPessoaJuridica extends Correntista {
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "cnpj", column = @Column(name = "cnpj"))
	private CNPJValido cnpj;
	
	private String razaoSocial;
	
	private LocalDate fundadoEm;
	
	public CorrentistaPessoaJuridica() {
		super();
	}

	public CorrentistaPessoaJuridica(CNPJValido cnpj, String razaoSocial, LocalDate fundadoEm, String nome) {
		super(nome);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fundadoEm = fundadoEm;
	}

	public CNPJValido getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJValido cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public LocalDate getFundadoEm() {
		return fundadoEm;
	}

	public void setFundadoEm(LocalDate fundadoEm) {
		this.fundadoEm = fundadoEm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorrentistaPessoaJuridica [cnpj=");
		builder.append(cnpj);
		builder.append(", razaoSocial=");
		builder.append(razaoSocial);
		builder.append(", fundadoEm=");
		builder.append(fundadoEm);
		builder.append(", Nome=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();
	}
	
}
