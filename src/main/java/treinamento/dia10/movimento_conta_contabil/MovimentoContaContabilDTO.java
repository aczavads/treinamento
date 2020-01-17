package treinamento.dia10.movimento_conta_contabil;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import treinamento.dia10.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovimentoContaContabilDTO extends BaseDTO<MovimentoContaContabil>{
	private String historico;
	private BigDecimal valor;
	private LocalDate efetuadoEm; 
	private TipoMovimentoContaContabil tipo;
	private Long contaContabilId;
	
	public MovimentoContaContabil toEntity() {
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
	public MovimentoContaContabil mergeEntity(MovimentoContaContabil entity) {
		return toEntity();
	}

}
