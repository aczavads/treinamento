package treinamento.dia5.jpa.fernando.santos;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private Integer valor;
	
	@SuppressWarnings("unused")
	private InteiroPositivo() {
	}

	public InteiroPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor n�o pode ser nulo ou menor que zero.");
		}
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
	
}
