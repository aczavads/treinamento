package william.dia10.Movimentos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import william.dia10.ContaContabil.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovimentoContaContabilDTO extends BaseDTO<MovimentoContaContabil> {
	private String historico;
	private BigDecimal valor;
	private LocalDate efetuadoEm;
	private TipoMovimentoContaContabil tipo;
	private Long contaContabilId;
	
	
	@Override
	protected MovimentoContaContabil toEntity() {
		// TODO Auto-generated method stub
		return MovimentoContaContabil.builder()
				.id(id)
				.version(version)
				.historico(historico)
				.valor(valor)
				.efetuadoEm(efetuadoEm)
				.tipo(tipo)
				.build();
	}

	@Override
	protected MovimentoContaContabil mergeEntity(MovimentoContaContabil actual) {
		return MovimentoContaContabil.builder()
				.id(id)
				.version(version)
				.historico(historico)
				.valor(valor)
				.efetuadoEm(efetuadoEm)
				.tipo(tipo)
				.build();
	}
}
