package diegomucheniski.domains;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {

	private Integer valor;
	
	public InteiroPositivo() {		
	}
	
	public InteiroPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor passado precisa ser positivo!");
		}
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(valor);		
		return builder.toString();
	}
		
}
