package treinamento.guilhermeperes.dia6.base;

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

	public UUID getId() {
		return id;
	}
}
