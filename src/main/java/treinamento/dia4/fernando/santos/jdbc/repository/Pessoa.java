package treinamento.dia4.fernando.santos.jdbc.repository;

import java.util.UUID;

public class Pessoa {

	private UUID id;
	private Integer codigo;
	private String nome;
	
	public Pessoa(Integer codigo, String nome) {
		this.id = UUID.randomUUID();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Pessoa(UUID id, Integer codigo, String nome) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", codigo=" + codigo + ", nome=" + nome + "]";
	}
	
}
