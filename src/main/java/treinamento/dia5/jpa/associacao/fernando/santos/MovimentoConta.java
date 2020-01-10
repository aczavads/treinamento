package treinamento.dia5.jpa.associacao.fernando.santos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MovimentoConta {

	@Column(nullable = false)
	private LocalDate efetuadoEm;

	@Column(nullable = false)
	private BigDecimal valor;

	@Column(nullable = false)
	private String historico;

	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipo;

	@SuppressWarnings("unused")
	private MovimentoConta() {
	}

	public MovimentoConta(LocalDate efetuadoEm, String historico, BigDecimal valor, TipoMovimentoConta tipo) {
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

	public TipoMovimentoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentoConta tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "MovimentoConta [efetuadoEm=" + efetuadoEm + ", valor=" + valor + ", historico=" + historico + ", tipo="
				+ tipo + "]";
	}

	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta debito = new MovimentoConta(efetuadoEm, historico, valor, TipoMovimentoConta.DEBIDO);
		return null;
	}

}
