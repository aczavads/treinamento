package guscam.dia10.movimentocontacontabil;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import guscam.dia10.base.BaseDTO;
import guscam.dia5.jpa.associacoes.TipoMovimentoConta;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovimentoContaContabilDTO extends BaseDTO<MovimentoContaContabil> {
	private String historico;	
	private BigDecimal valor;
	private LocalDate efetuadoEm;
	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipo;
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
				.build();
	}
}
