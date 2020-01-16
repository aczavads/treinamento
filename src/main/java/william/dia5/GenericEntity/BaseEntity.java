package william.dia5.GenericEntity;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {
	@Id
	private UUID id;
<<<<<<< HEAD:src/main/java/william/dia5/GenericEntity/BaseEntity.java

=======
	
	@Version
	private int version;
	
	public int getVersion() {
		return version;
	}
	
>>>>>>> 838b589a310fd43af5f7bd9427e06e95a6f1e244:src/main/java/treinamento/dia5/jpa/associacoes/BaseEntity.java
	public BaseEntity() {
		this.id = UUID.randomUUID();
	}
	
	public BaseEntity(UUID id, int version) {
		if (id == null) {
			id = UUID.randomUUID();
		}
		this.id = id;
		this.version = version;
	}

	public BaseEntity(UUID id) {
		if (id == null) {
<<<<<<< HEAD:src/main/java/william/dia5/GenericEntity/BaseEntity.java
			this.id = UUID.randomUUID();
		} else {

			this.id = id;
		}
=======
			id = UUID.randomUUID();
		}
		this.id = id;
>>>>>>> 838b589a310fd43af5f7bd9427e06e95a6f1e244:src/main/java/treinamento/dia5/jpa/associacoes/BaseEntity.java
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
