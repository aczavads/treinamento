package treinamento.guilhermeperes.dia4.jdbc;

import java.util.UUID;

public class Pessoa {
	private UUID id;
	private Integer codigo;
	private String nome;
	
	public Pessoa(UUID id, Integer codigo, String nome) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Pessoa(Integer codigo, String nome) {
		this.id = UUID.randomUUID();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public UUID getId() {
		return id;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
}
