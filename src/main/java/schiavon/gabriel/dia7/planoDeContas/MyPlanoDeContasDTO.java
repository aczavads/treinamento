package schiavon.gabriel.dia7.planoDeContas;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class MyPlanoDeContasDTO {
	
	private UUID id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate terminoVigencia;
}
