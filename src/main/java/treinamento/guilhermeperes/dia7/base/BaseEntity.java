package treinamento.guilhermeperes.dia7.base;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	private UUID id;

	public BaseEntity() {
		this.id = UUID.randomUUID();
	}

	public BaseEntity(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
