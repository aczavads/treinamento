package schiavon.gabriel.dia5.jpa.associacoes;

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
	private BigDecimal valor;

	@Column(nullable = false)
	private String historico;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoMovimentoConta tipoMovimento;

	private MovimentoConta() {
		super();
	}

	public MovimentoConta(LocalDate efetuadoEm, BigDecimal valor, String historico, TipoMovimentoConta tipoMovimento) {
		super();
		this.efetuadoEm = efetuadoEm;
		this.valor = valor;
		this.historico = historico;
		this.tipoMovimento = tipoMovimento;
	}

	public LocalDate getEfetuadoEm() {
		return efetuadoEm;
	}

	public void setEfetuadoEm(LocalDate efetuadoEm) {
		this.efetuadoEm = efetuadoEm;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public TipoMovimentoConta getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimentoConta tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	@Override
	public String toString() {
		return "MovimentoConta [efetuadoEm=" + efetuadoEm + ", valor=" + valor + ", historico=" + historico
				+ ", tipoMovimento=" + tipoMovimento + ", getId()=" + getId() + "]";
	}
}
