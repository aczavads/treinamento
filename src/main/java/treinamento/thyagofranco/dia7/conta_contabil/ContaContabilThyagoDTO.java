package treinamento.thyagofranco.dia7.conta_contabil;

import java.util.UUID;

import lombok.Data;

@Data
public class ContaContabilThyagoDTO {
	private UUID id;
	private UUID contaSuperiorId;
	private String nome;
	private String codigo;

}
