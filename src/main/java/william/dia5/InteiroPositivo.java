package william.dia5;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	private final Integer valor;

	public InteiroPositivo(Integer valor) {

		if (valor < 0) {
			throw new RuntimeException("valor dever ser maior que zero!");
		}
		this.valor = valor;
	}
	
	
	
	private InteiroPositivo() {
		this.valor = null;
	}



	public Integer getValor() {
		return valor;
	}
}
