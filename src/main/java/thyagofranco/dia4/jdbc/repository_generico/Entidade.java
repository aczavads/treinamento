package thyagofranco.dia4.jdbc.repository_generico;

import java.util.UUID;

public class Entidade {
	@ChavePrimaria
	private UUID id;

	public Entidade() {
		this.id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
}
