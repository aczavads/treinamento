package fernando_santos.treinamento.dia8.dto;

import java.util.UUID;

public class HierarquiaDTO {
	private UUID id;
	private UUID contaSuperiorId;
	private String codigo;
	private String nome;
	private int nivel;
	
	public HierarquiaDTO(UUID id, UUID contaSuperiorId, String codigo, String nome, int nivel) {
		super();
		this.id = id;
		this.contaSuperiorId = contaSuperiorId;
		this.codigo = codigo;
		this.nome = nome;
		this.nivel = nivel;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getContaSuperiorId() {
		return contaSuperiorId;
	}

	public void setContaSuperiorId(UUID contaSuperiorId) {
		this.contaSuperiorId = contaSuperiorId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	

	
	
}
