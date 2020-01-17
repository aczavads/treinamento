package fernando_santos.treinamento.dia10.conta_contabil;

import fernando_santos.treinamento.dia10.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
				.codigo(codigo)
				.nome(nome)
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
