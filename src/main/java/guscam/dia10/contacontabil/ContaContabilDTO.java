package guscam.dia10.contacontabil;

import guscam.dia10.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContaContabilDTO extends BaseDTO<ContaContabil> {
	private String nome;
	private String codigo;
	private Long contaSuperiorId;

	@Override
	public ContaContabil toEntity() {
		return ContaContabil.builder()
				.id(id)
				.version(version)
				.nome(nome)
				.codigo(codigo)
				.build();
	}

	@Override
	public ContaContabil mergeEntity(ContaContabil entity) {
		entity.setVersion(version);
		entity.setNome(nome);
		entity.setCodigo(codigo);
		return entity;
	}
}
