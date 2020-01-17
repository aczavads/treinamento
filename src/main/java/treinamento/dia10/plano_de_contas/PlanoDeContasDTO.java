package treinamento.dia10.plano_de_contas;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import treinamento.dia10.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlanoDeContasDTO extends BaseDTO {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

}
