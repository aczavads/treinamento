package treinamento.guilhermeperes.dia5.jpa.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {
	
	@Column(nullable = false, unique = true)
	//private CNPJ cnpj;
	private String cnpj;

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}
}
