package treinamento.matheusfaxina.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "delete_correntista_fisica", query = "DELETE FROM CorrentistaFisica") })
@Entity
public class CorrentistaFisica extends Correntista {

	@Embedded
	@Column(nullable = false)
	private CPF cpf;

	@Column(nullable = false)
	private String razaoSocial;

	@Column(nullable = false)
	private LocalDate fundadaEm;

	public CorrentistaFisica() {
		super();
	}

	public CorrentistaFisica(CPF cpf, String razaoSocial, LocalDate fundadaEm, String nome) {
		this();
		this.setNome(nome);
		this.fundadaEm = fundadaEm;
		this.razaoSocial = razaoSocial;
		this.cpf = cpf;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
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

}
