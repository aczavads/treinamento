package guscam.dia7.contacontabil;

import java.util.UUID;

import lombok.Data;

@Data
public class ContaContabilDTO {
	private UUID id;
	private UUID contaSuperiorId;
	private String codigo;
	private String nome;
}
