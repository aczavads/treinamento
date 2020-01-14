package treinamento.dia7.conta_contabil;

import java.util.UUID;

import lombok.Data;

@Data
public class ContaContabilDTO {
	private UUID id;
	private UUID contaSuperior;
	private String nome;
	private String codigo;
}
