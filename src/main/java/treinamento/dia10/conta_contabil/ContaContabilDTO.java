package treinamento.dia10.conta_contabil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import treinamento.dia10.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContaContabilDTO extends BaseDTO {
	private Long contaSuperiorId;
	private String nome;
	private String codigo;
}
