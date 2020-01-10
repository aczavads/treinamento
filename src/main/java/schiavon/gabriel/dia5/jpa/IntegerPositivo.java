package schiavon.gabriel.dia5.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class IntegerPositivo {
	private Integer valor;

	private IntegerPositivo() {
	}

	public IntegerPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor não é um inteiro negativo");
		}
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return valor.toString();
	}
	
	
}
