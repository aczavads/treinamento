package schiavon.gabriel.dia7.movimentoContaContabil;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabil;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString
@NoArgsConstructor
public class MyMovimentoContaContabil extends BaseEntity<Long> {

	private String historico;
	private BigDecimal valor;
	private LocalDate efetuadoEm;
	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipoMovimento;
	@JsonIgnore
	@ManyToOne
	private MyContaContabil contaContabil;
	
	public Long getContaContabilId() {
		return contaContabil.getId();
	}
}
