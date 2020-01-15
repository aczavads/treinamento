package thais.matera.dia7.conta_contabil.plano;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class PlanoDeContasDTO {
	private UUID id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
}
