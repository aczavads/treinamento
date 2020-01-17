package schiavon.gabriel.dia7.planoDeContas;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MyPlanoDeContasDTO {
	
	private Long id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate terminoVigencia;
}
