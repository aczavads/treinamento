package treinamento.matheusfaxina.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "delete_correntista_juridico", query = "DELETE FROM CorrentistaJuridica") })
@Entity
public class CorrentistaJuridica extends Correntista {

	@Column(nullable = false)
	@Embedded
	private CNPJ cnpj;

	@Column(nullable = false)
	private String razaoSocial;

	@Column(nullable = false)
	private LocalDate fundadaEm;

	public CorrentistaJuridica() {
		super();
	}

	public CorrentistaJuridica(CNPJ cnpj, String razaoSocial, LocalDate fundadaEm, String nome) {
		this();
		this.setNome(nome);
		this.fundadaEm = fundadaEm;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
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

}
