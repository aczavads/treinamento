package thais.matera.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class MyCorrentistaJuridica extends MyCorrentista {
	@Column(unique = true, nullable = false)
	private String razaoSocial;
	
	@Column(unique = true, nullable = false)
	private LocalDate fundadaEm;
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name="cnpjdaempresa"))
	private CNPJ cnpj;
	
	public MyCorrentistaJuridica() {
		super();
	}
	
	@Override
	public String toString() {
		return "CorrentistaJuridica [razaoSocial=" + razaoSocial + ", fundadaEm=" + fundadaEm + ", cnpj=" + cnpj + "]";
	}

	public MyCorrentistaJuridica(String nome, CNPJ cnpj, String razaoSocial, LocalDate fundadaEm) {
		super(nome);
		this.razaoSocial = razaoSocial;
		this.fundadaEm = fundadaEm;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public LocalDate getFundadaEm() {
		return fundadaEm;
	}


	public CNPJ getCnpj() {
		return cnpj;
	}
	
}
