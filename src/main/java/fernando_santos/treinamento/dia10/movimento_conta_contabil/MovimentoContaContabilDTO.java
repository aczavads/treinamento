package fernando_santos.treinamento.dia10.movimento_conta_contabil;

import java.math.BigDecimal;
import java.time.LocalDate;

import fernando_santos.treinamento.dia10.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovimentoContaContabilDTO extends BaseDTO<MovimentoContaContabil> {

	private String historico;
	private BigDecimal valor;
	private LocalDate efetuadoEm;
	private TipoMovimentoContaContabil tipo;
	private Long contaContabilId;

	@Override
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
		return MovimentoContaContabil.builder()
				.id(id)
				.version(version)
				.historico(historico)
				.valor(valor)
				.efetuadoEm(efetuadoEm)
				.tipo(tipo)
				.contaContabil(entity.getContaContabil())
				.build();
	}

}
