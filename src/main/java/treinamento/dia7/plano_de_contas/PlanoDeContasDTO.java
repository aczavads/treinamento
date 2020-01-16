package treinamento.dia7.plano_de_contas;

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
