package treinamento.diegomucheniski.dia7.plano_de_contas;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import treinamento.diegomucheniski.domains.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true) // Chama o equals e hashCode do BaseEntity
@NoArgsConstructor
public class PlanoDeContasMucheniskiDTO extends BaseEntity {	
	private UUID id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

}
