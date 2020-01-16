package valdenir.junior.dia7.plano_de_contas;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import lombok.Data;
import valdenir.junior.dia7.conta_contabil.ContaContabils;

@Data
public class PlanoDeContassDTO {
	private UUID id;
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	private Set<ContaContabils> contasContabil;
}
