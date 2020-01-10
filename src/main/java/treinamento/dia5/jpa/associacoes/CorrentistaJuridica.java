package treinamento.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class CorrentistaJuridica extends Correntista {
	@Column(nullable = false, unique = true)
	public String razaoSocial;
	@Column(nullable = false)
	public LocalDate fundadaEm;
	
	public CorrentistaJuridica() {
		super();
	}
	
	public CorrentistaJuridica(String nome, String razaoSocial, LocalDate fundadaEm) {
		super(nome);
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
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
		return "CorrentistaJuridica [razaoSocial=" + razaoSocial + ", fundadaEm=" + fundadaEm + ", getNome()="
				+ getNome() + "]";
	}
	
	
	
	
}
