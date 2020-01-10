package guscam.dia5.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private Integer valor;
	
	private InteiroPositivo() {
		this.valor = 0;
	}

	public InteiroPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor deve ser um inteiro positivo!");
		}
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return String.valueOf(valor);
	}
	
	

}
