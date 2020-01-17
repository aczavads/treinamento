package william.dia10.Movimentos;

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
import william.dia10.BaseEntity;
import william.dia10.ContaContabil.ContaContabil;


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
	private TipoMovimentoContaContabil tipo;
	
	@JsonIgnore
	@ManyToOne
	private ContaContabil contaContabil;
	
	public Long getContaContabilId() {
		return this.contaContabil.getId();
	}
}
