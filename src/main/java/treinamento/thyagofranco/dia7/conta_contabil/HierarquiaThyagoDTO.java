package treinamento.thyagofranco.dia7.conta_contabil;

import java.util.UUID;

public class HierarquiaThyagoDTO {
	private UUID id;
	private UUID contaSuperior;
	private String codigo;
	private String nome;
	private int nivel;
	
	public HierarquiaThyagoDTO() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public UUID getContaSuperior() {
		return contaSuperior;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getNivel() {
		return nivel;
	}
	
	
	
}
