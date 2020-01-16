package treinamento.thyagofranco.dia7.plano_de_contas.DTO;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
@Data
public class PlanoDeContasTDTO {
	private UUID id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
}
