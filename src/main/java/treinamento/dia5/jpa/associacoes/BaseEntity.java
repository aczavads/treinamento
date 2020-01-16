package treinamento.dia5.jpa.associacoes;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import liquibase.pro.packaged.iF;

@MappedSuperclass
public class BaseEntity {
	@Id
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	public BaseEntity() {
		id = UUID.randomUUID();
	}

	public BaseEntity(UUID id) {
		if(id == null) {
			id = UUID.randomUUID();
		}
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
