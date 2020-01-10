package FelipeSilva.jdbc.repo_generico;

import java.util.UUID;

public class Entidade {
	@ChavePrimaria
	private UUID id;

public Entidade() {
	this.id = UUID.randomUUID();
}
public UUID getid() {
	return id;
}
}