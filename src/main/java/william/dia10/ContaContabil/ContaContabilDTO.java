package william.dia10.ContaContabil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContaContabilDTO extends BaseDTO<ContaContabil> {

	private Long contaSuperiorId;
	private String nome;
	private String codigo;
	@Override
	protected ContaContabil toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void mergeEntity(ContaContabil actual) {
		// TODO Auto-generated method stub
		
	}
}
