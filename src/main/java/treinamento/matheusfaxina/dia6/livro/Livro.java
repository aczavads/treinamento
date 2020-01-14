package treinamento.matheusfaxina.dia6.livro;

import javax.persistence.Entity;

import treinamento.matheusfaxina.associacoes.BaseEntity;

@Entity
public class Livro extends BaseEntity {

	private String tipo;

	public Livro() {
		super();
	}

	public Livro(String tipo) {
		this();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Livro [tipo=" + tipo + "]";
	}

}
