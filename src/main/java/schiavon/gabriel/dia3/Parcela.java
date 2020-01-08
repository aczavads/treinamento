package schiavon.gabriel.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Parcela {
	private int numeroParcela;
	private LocalDate dataVencimento;
	private BigDecimal valorParcela;

	public Parcela() {
	}

	public Parcela(int numeroParcela, LocalDate dataVencimento, BigDecimal valorParcela) {
		this.numeroParcela = numeroParcela;
		this.dataVencimento = dataVencimento;
		this.valorParcela = valorParcela;
	}

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	@Override
	public String toString() {
		return "Parcela [numeroParcela=" + numeroParcela + ", dataVencimento=" + dataVencimento + ", valorParcela="
				+ valorParcela + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + numeroParcela;
		result = prime * result + ((valorParcela == null) ? 0 : valorParcela.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcela other = (Parcela) obj;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (numeroParcela != other.numeroParcela)
			return false;
		if (valorParcela == null) {
			if (other.valorParcela != null)
				return false;
		} else if (!valorParcela.equals(other.valorParcela))
			return false;
		return true;
	}
}
