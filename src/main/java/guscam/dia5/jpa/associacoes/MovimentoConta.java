package guscam.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import guscam.dia7.BaseEntity;

@Entity
public class MovimentoConta extends BaseEntity {

	@Column(nullable = false)
	private LocalDate dataDaMovimentacao;

	@Column(nullable = false)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoMovimentoConta tipo;

	@Column(nullable = false)
	private String historico;
	
	private MovimentoConta() {
	}

	public MovimentoConta(LocalDate dataDaMovimentacao, BigDecimal valor, String historico, TipoMovimentoConta tipo) {
		super();
		this.valor = valor;
		this.dataDaMovimentacao = dataDaMovimentacao;
		this.historico = historico;
		this.tipo = tipo;
	}

	public LocalDate getDataDaMovimentacao() {
		return dataDaMovimentacao;
	}

	public void setDataDaMovimentacao(LocalDate dataDaMovimentacao) {
		this.dataDaMovimentacao = dataDaMovimentacao;
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

	@Override
	public String toString() {
		return "MovimentoConta [dataDaMovimentacao=" + dataDaMovimentacao + ", valor=" + valor + ", tipo=" + tipo
				+ ", historico=" + historico + "]";
	}	

}
