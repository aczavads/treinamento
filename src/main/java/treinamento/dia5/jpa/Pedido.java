package treinamento.dia5.jpa;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Pedido {
	@Id
	private UUID id;
	
	
	public Pedido() {
	}
	
	public UUID getId() {
		return id;
	}
	

}
