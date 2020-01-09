package thais.matera.dia4.jdbc.repogeneric;

import java.util.UUID;

public class Entity {
	@PrimaryKey
	private UUID id;
	
	public Entity() {
		this.id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
}
