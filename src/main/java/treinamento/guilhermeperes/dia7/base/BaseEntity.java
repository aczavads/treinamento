package treinamento.guilhermeperes.dia7.base;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {
	
	@Id
	private UUID id;

	public BaseEntity() {
		this.id = UUID.randomUUID();
	}
}
