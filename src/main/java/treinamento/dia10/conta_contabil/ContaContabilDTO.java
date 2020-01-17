package treinamento.dia10.conta_contabil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import treinamento.dia10.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContaContabilDTO extends BaseDTO<ContaContabil> {
	private Long contaSuperiorId;
	private String nome;
	private String codigo;
	
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
