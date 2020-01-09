package thais.matera.dia4.jdbc.repository;

import java.util.UUID;

public class Person {
	private UUID id;
	private Integer code;
	private String name;

	public Person(UUID id, Integer code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public Person(Integer code, String name) {
		this.code = code;
		this.name = name;
		this.id = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", code=" + code + ", name=" + name + "]";
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public UUID getId() {
		return id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
