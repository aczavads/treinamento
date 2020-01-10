package GLF.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import GLF.dia5.jpa.enumeracoes.TipoMovimentoConta;

@Entity
public class MovimentoConta extends BaseEntity {
	
	@Column(nullable = false)
	private LocalDate efetuadoEm;
	@Column(nullable = false)
	private String historico;
	@Column(nullable = false)
	private BigDecimal valor;
	@Enumerated
	private TipoMovimentoConta tipo;
	
	public MovimentoConta() {
		
	}

}
