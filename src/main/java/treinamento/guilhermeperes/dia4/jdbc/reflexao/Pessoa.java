package treinamento.guilhermeperes.dia4.jdbc.reflexao;

import java.util.UUID;

public class Pessoa {
	@Id
	private UUID id;
	private Integer codigo;
	private String nome;
	
	public Pessoa(UUID id, Integer codigo, String nome) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Pessoa(Integer codigo, String nome) {
		this.id = UUID.randomUUID();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Pessoa() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", codigo=" + codigo + ", nome=" + nome + "]";
	}
}
