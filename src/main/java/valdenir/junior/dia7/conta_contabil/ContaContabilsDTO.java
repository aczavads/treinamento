package valdenir.junior.dia7.conta_contabil;

import java.util.UUID;

import lombok.Data;

@Data
public class ContaContabilsDTO {
	private UUID id;
	private UUID contaSuperior;
	private String nome;
	private String codigo;
}
