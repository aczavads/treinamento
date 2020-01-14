package treinamento.matheusfaxina.jdbc_generic;

import java.util.UUID;

public class Entidade {

	private UUID id;

	public Entidade() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

}
