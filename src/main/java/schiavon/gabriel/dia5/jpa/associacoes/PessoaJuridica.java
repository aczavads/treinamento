package schiavon.gabriel.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Correntista {

	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "cnpj"))
	private CNPJ cnpj;

	@Column
	private String razaoSocial;

	@Column
	private LocalDate fundadaEm;

	public PessoaJuridica(String nome, CNPJ cnpj, String razaoSocial, LocalDate fundadaEm) {
		super(nome);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
	}

	private PessoaJuridica() {
		super();
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
		return "PessoaJuridica [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", fundadaEm=" + fundadaEm + "]";
	}
}
