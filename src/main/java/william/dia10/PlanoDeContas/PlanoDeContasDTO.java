package william.dia10.PlanoDeContas;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import william.dia10.ContaContabil.BaseDTO;
import william.dia10.ContaContabil.ContaContabil;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlanoDeContasDTO extends BaseDTO<PlanoDeContas>{
	
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	@Override
	protected PlanoDeContas toEntity() {
		
		return PlanoDeContas.builder()
				.id(id)
				.version(version)
				.descricao(descricao)
				.inicioVigencia(inicioVigencia)
				.fimVigencia(fimVigencia)
				.build();
	}
	@Override
	protected void mergeEntity(PlanoDeContas actual) {
		// TODO Auto-generated method stub
		
	}

}
