package schiavon.gabriel.dia7.conta_contabil;

import lombok.Data;

@Data
public class MyContaContabilDTO {
	private Long id;
	private Long contaSuperiorId;
	private String nome;
	private String codigo;
}
