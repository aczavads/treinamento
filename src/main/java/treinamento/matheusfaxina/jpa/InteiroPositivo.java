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
			throw new RuntimeException("O valor n�o � um inteiro positivo!");
		}
		
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}

}
