package guscam.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class CorrentistaJuridica extends Correntista {

	@Embedded
	@Column(unique = true, nullable = false)
	private Cnpj cnpj;
	
	private String razaoSocial;
	private LocalDate dataDeFundacao;
	
	public CorrentistaJuridica() {
		super();
	}
	public CorrentistaJuridica(String nome, Cnpj cnpj, String razaoSocial, LocalDate dataDeFundacao) {
		super(nome);
		System.out.println("######################%%%%%%%" + cnpj);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.dataDeFundacao = dataDeFundacao;
	}
	public Cnpj getCnpj() {
		return cnpj;
	}
	public void setCnpj(Cnpj cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}
	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}
}
