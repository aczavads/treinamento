package schiavon.gabriel.dia7.planoDeContas;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import schiavon.gabriel.dia7.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyPlanoDeContasDTO extends BaseDTO<Long, MyPlanoDeContas>{
	
	private Long id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate terminoVigencia;
	
	@Override
	protected MyPlanoDeContas toEntity() {
		return MyPlanoDeContas
				.builder()
				.id(id)
				.descricao(descricao)
				.inicioVigencia(inicioVigencia)
				.terminoVigencia(terminoVigencia)
				.build();
				
	}

	@Override
	protected MyPlanoDeContas mergeEntity(MyPlanoDeContas entidade) {
		return toEntity();
	}
}
