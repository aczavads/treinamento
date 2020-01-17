package thyagofranco.dia10.conta_contabil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import thyagofranco.dia10.conta_contabil.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContaContabilDTO extends BaseDTO{

	private Long contaSuperiorId;
	private String nome;
	private String codigo;
	
}
