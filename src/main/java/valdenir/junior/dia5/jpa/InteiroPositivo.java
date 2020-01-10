package valdenir.junior.dia5.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private Integer valor;

	private InteiroPositivo() {
	}

	public InteiroPositivo(Integer valor) {
		if (valor < 0)
			throw new RuntimeException();
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
}
