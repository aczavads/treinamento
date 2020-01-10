package thais.matera.dia5.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private final Integer valor;
	
	public InteiroPositivo() {
		this.valor = 0;
	}
	
	public InteiroPositivo(Integer valor) {
		if(valor < 0) {
			throw new RuntimeException("O valor não eh um inteiro positivo!");
		}
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
}
