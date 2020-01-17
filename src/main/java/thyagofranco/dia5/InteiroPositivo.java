package thyagofranco.dia5;

import javax.persistence.Embeddable;

@Embeddable
public class InteiroPositivo {
	
	private Integer valor;
	
// JPA precisa de um construtor padrão para conseguir mapear por reflaction 	
//	public InteiroPositivo() {
//		this.valor = 0;
//	}
	
	private InteiroPositivo() {		
	}
	
	public InteiroPositivo(Integer valor) {
		if(!(valor > 0) || valor == null) {
			throw new RuntimeException("O valor não é um inteiro positivo");
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
