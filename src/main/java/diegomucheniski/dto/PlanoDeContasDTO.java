package diegomucheniski.dto;

import java.time.LocalDate;
import java.util.UUID;

import diegomucheniski.domains.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Chama o equals e hashCode do BaseEntity
@NoArgsConstructor
public class PlanoDeContasDTO extends BaseEntity {	
	private UUID id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

}
