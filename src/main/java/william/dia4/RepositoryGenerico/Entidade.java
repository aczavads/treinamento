package william.dia4.RepositoryGenerico;

import java.util.UUID;

public class Entidade {
	@ChavePrimaria
	private UUID id;

	public UUID getId() {
		return id;
	}
	public Entidade() {
		this.id = UUID.randomUUID();
	}

}
