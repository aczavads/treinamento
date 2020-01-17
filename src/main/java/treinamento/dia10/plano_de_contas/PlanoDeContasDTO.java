package treinamento.dia10.plano_de_contas;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanoDeContasDTO {
	private Long id;
	private int version;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

}
