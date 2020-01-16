package fernando_santos.treinamento.dia4.jdbc.repo_generico.domain;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -139681233375246713L;
	
	@ChavePrimaria
	private UUID id;
	
	public BaseEntity() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

}
