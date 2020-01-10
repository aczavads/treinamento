package GLF.dia5.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private  Integer valor;
	
	public InteiroPositivo() {
		this.valor = 0;
	}
	
	
	public InteiroPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor não é um inteiro positivo");
		}
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
	
	
}
