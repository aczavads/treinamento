package giovani.bueno.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class CorrentistaJuridica extends Correntista {
	
	@Embedded
	@Column(unique= true)
	@AttributeOverride(name = "valor",column = @Column(name="CNPJ"))
	private CNPJ CNPJ;
	
	private String razaoSocial;
	private LocalDate fundadaEm;
	
	public CorrentistaJuridica(String nome,CNPJ cNPJ, String razaoSocial, LocalDate fundadaEm) {
		super();
		CNPJ = cNPJ;
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
		this.setNome(nome);
	}
	
	public CNPJ getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(CNPJ cNPJ) {
		CNPJ = cNPJ;
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
	public void setNome(String nome) {
		super.setNome(nome);
	}

	@Override
	public String toString() {
		return "CorrentistaJuridica [CNPJ=" + CNPJ + ", razaoSocial=" + razaoSocial + ", fundadaEm=" + fundadaEm + "]";
	}

	
	
}
