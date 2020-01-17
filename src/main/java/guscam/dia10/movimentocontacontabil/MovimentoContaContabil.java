package guscam.dia10.movimentocontacontabil;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import guscam.dia10.base.BaseEntity;
import guscam.dia10.contacontabil.ContaContabil;
import guscam.dia5.jpa.associacoes.TipoMovimentoConta;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class MovimentoContaContabil extends BaseEntity {
	private String historico;	
	private BigDecimal valor;
	private LocalDate efetuadoEm;
	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipo;
	
	@JsonIgnore
	@ManyToOne
	private ContaContabil contaContabil;
}
