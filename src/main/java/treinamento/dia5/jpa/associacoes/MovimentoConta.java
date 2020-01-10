package treinamento.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class MovimentoConta extends BaseEntity {
	@Column(nullable = false)
	private LocalDate efetuadoEm;
	
	@Column(nullable = false)
	private String historico;	
	
	@Column(nullable = false)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipo;

	public MovimentoConta() {
		super();
	}
	
	public MovimentoConta(LocalDate efetuadoEm, String historico, BigDecimal valor, TipoMovimentoConta tipo) {
		super();
		this.efetuadoEm = efetuadoEm;
		this.historico = historico;
		this.valor = valor;
		this.tipo = tipo;
	}

	public LocalDate getEfetuadoEm() {
		return efetuadoEm;
	}

	public void setEfetuadoEm(LocalDate efetuadoEm) {
		this.efetuadoEm = efetuadoEm;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentoConta tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "MovimentoConta [efetuadoEm=" + efetuadoEm + ", historico=" + historico + ", valor=" + valor + ", tipo="
				+ tipo + "]";
	}
	
	
	
}
