package treinamento.dia5.jpa;

import javax.persistence.Embeddable;

import org.springframework.jmx.access.InvalidInvocationException;

@Embeddable
public class InteiroPositivo {
	private Integer valor;
	
	private InteiroPositivo() {
		//throw new InvalidInvocationException("Não pode chamar esse não!");
	}
	
	public InteiroPositivo(Integer valor) {
		if (valor == null || valor < 0) {
			throw new RuntimeException("O valor não é um inteiro positivo!");
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
