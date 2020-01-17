package treinamento.dia10.conta_contabil;

import lombok.Data;

@Data
public class ContaContabilDTO {
	private Long id;
	private Long contaSuperiorId;
	private String nome;
	private String codigo;
	private int version;
}
