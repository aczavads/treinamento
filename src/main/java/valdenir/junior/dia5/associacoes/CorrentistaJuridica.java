package valdenir.junior.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class CorrentistaJuridica extends Correntista {
	@Embedded
	@AttributeOverride(name = "valor", column = @Column(name = "cnpj"))
	private CNPJ cnpj;
	private String razaoSocial;
	private LocalDate fundadaEm;

	public CorrentistaJuridica() {
		super();
	}

	public CorrentistaJuridica(CNPJ cnpj, String razaoSocial, LocalDate fundadaEm, String nome) {
		this();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
		this.setNome(nome);
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
