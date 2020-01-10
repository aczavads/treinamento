package treinamento.guilhermeperes.dia5.jpa.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {

	@Column(nullable = false, unique = true)
	private CPF cpf;

	public PessoaFisica(String nome, CPF cpf) {
		super(nome);
		this.cpf = cpf;
	}
	
	public PessoaFisica() {
		super();
	}

	public CPF getCpf() {
		return cpf;
	}
}
