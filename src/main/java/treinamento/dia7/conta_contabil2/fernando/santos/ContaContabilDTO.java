package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.UUID;

import lombok.Data;

@Data
public class ContaContabilDTO {
	private UUID id;
	private UUID contaSuperiorId;
	private String nome;
	private String codigo;
}
