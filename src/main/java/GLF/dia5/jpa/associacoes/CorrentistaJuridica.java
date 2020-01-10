package GLF.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CorrentistaJuridica extends Correntista {

	private CNPJ cnpjCorrentista;
	
	@Column(nullable = false, unique = true)
	private String razaoSocial;
	
	@Column(nullable = false)
	private LocalDate fundadaEm;
	
	public CorrentistaJuridica() {
		super();
	}
	
	public CorrentistaJuridica(String nome, CNPJ cnpjCorrentista, String razaoSocial, LocalDate fundadaEm) {
		super();
		this.cnpjCorrentista = cnpjCorrentista;
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
		setNome(nome);
	}

	public CNPJ getCnpjCorrentista() {
		return cnpjCorrentista;
	}

	public void setCnpjCorrentista(CNPJ cnpjCorrentista) {
		this.cnpjCorrentista = cnpjCorrentista;
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
		return "CorrentistaJuridica [cnpjCorrentista=" + cnpjCorrentista + ", razaoSocial=" + razaoSocial
				+ ", fundadaEm=" + fundadaEm + ", getNome()=" + getNome() + "]";
	}
	
	
	
	
}
