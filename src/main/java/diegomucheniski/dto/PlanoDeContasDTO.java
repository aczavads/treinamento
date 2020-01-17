package diegomucheniski.dto;

import java.time.LocalDate;

import diegomucheniski.base.BaseDTO;
import diegomucheniski.domains.PlanoDeContas;
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
					.id(id) // Vem do Super
					.version(version) // Vem do Super
					.descricao(descricao)
					.inicioVigencia(inicioVigencia)
					.fimVigencia(fimVigencia)
					.build();
	}

	@Override
	public PlanoDeContas mergeEntity(PlanoDeContas planoDeContas) {
		planoDeContas.setVersion(version);
		planoDeContas.setDescricao(descricao);
		planoDeContas.setInicioVigencia(inicioVigencia);
		planoDeContas.setFimVigencia(fimVigencia);		
		return planoDeContas;
	}
}
