package schiavon.gabriel.dia7.movimentoContaContabil;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import schiavon.gabriel.dia7.base.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyMovimentoContaContabilDTO extends BaseDTO<Long, MyMovimentoContaContabil> {

	private String historico;
	private BigDecimal valor;
	private LocalDate efetuadoEm;
	private TipoMovimentoConta tipo;
	private Long contaContabilId;

	@Override
	protected MyMovimentoContaContabil toEntity() {
		return MyMovimentoContaContabil
				.builder()
				.id(getId())
				.historico(historico)
				.valor(valor)
				.efetuadoEm(efetuadoEm)
				.tipoMovimento(tipo)
				.build();
	}

	@Override
	protected MyMovimentoContaContabil mergeEntity(MyMovimentoContaContabil entidade) {
		return MyMovimentoContaContabil
				.builder()
				.id(getId())
				.historico(historico)
				.valor(valor)
				.efetuadoEm(efetuadoEm)
				.tipoMovimento(tipo)
				.contaContabil(entidade.getContaContabil())
				.build();
	}

}
