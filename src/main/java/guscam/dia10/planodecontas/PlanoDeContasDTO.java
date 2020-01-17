package guscam.dia10.planodecontas;

import java.time.LocalDate;

import guscam.dia10.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlanoDeContasDTO extends BaseDTO<PlanoDeContas> {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

	@Override
	public PlanoDeContas toEntity() {
		return PlanoDeContas.builder()
				.id(id)
				.version(version)
				.descricao(descricao)
				.inicioVigencia(inicioVigencia)
				.fimVigencia(fimVigencia)
				.build();
	}

	@Override
	public PlanoDeContas mergeEntity(PlanoDeContas entity) {
		entity.setVersion(version);
		entity.setDescricao(descricao);
		entity.setFimVigencia(fimVigencia);
		entity.setInicioVigencia(inicioVigencia);
		return entity;
	}
}
