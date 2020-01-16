package fernando_santos.treinamento.dia5.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private Integer valor;
	
	@SuppressWarnings("unused")
	private InteiroPositivo() {
	}

	public InteiroPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor não pode ser nulo ou menor que zero.");
		}
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
	
}
