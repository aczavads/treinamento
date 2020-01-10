package valdenir.junior.dia4.jdbc;

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
