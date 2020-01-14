package treinamento.matheusfaxina.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	
	private final Integer valor;
	
	private InteiroPositivo() {
		this.valor = null;
	}
	
	public InteiroPositivo(Integer valor) {
		if (valor < 0) {
			throw new RuntimeException("O valor não é um inteiro positivo!");
		}
		
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}

}
