package treinamento.guilhermeperes.dia5.jpa.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {

	@Column(nullable = false, unique = true)
	// private CPF cpf;
	private String cpf;

	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}
	
	public PessoaFisica() {
		super();
	}

	public String getCpf() {
		return cpf;
	}
}
