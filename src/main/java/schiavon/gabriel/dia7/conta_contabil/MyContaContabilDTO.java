package schiavon.gabriel.dia7.conta_contabil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import schiavon.gabriel.dia7.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyContaContabilDTO extends BaseDTO<Long, MyContaContabil> {
	private Long id;
	private Long contaSuperiorId;
	private String nome;
	private String codigo;
	
	@Override
	protected MyContaContabil toEntity() {
		return MyContaContabil
				.builder()
				.id(id)
				.nome(nome)
				.codigo(codigo)
				.build();
	}

	@Override
	protected MyContaContabil mergeEntity(MyContaContabil entidade) {
		return MyContaContabil
				.builder()
				.id(id)
				.nome(nome)
				.codigo(codigo)
				.contaSuperior(entidade.getContaSuperior())
				.build();
	}
}
