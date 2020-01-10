package treinamento.guilhermeperes.dia5.jpa.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {
	
	@Column(nullable = false, unique = true)
	private CNPJ cnpj;

	public PessoaJuridica(String nome, CNPJ cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica() {
		super();
	}

	public CNPJ getCnpj() {
		return cnpj;
	}
}
