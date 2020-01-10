package giovani.bueno.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
 
	private Integer valor;
    
	private InteiroPositivo() {
		this.valor = 0;
	}
	public InteiroPositivo(Integer valor) {

		if(valor == null || valor < 0 ) {
		   throw new RuntimeException("O v�lor n�o � um inteiro positivo!");
		}
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
}
