package fernando_santos.treinamento.dia2.parcelamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Parcela {
	
	private int numeroDaParcela;
	private LocalDate dataDeVencimento;
	private BigDecimal valorDaParcela;
	
	public Parcela(int numeroDaParcela, LocalDate dataDeVencimento, BigDecimal valorDaParcela) {
		this.numeroDaParcela = numeroDaParcela;
		this.dataDeVencimento = dataDeVencimento;
		this.valorDaParcela = valorDaParcela;
	}

	public int getNumeroDaParcela() {
		return numeroDaParcela;
	}

	public LocalDate getDataDeVencimento() {
		return dataDeVencimento;
	}

	public BigDecimal getValorDaParcela() {
		return valorDaParcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeVencimento == null) ? 0 : dataDeVencimento.hashCode());
		result = prime * result + numeroDaParcela;
		result = prime * result + ((valorDaParcela == null) ? 0 : valorDaParcela.hashCode());
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
		if (dataDeVencimento == null) {
			if (other.dataDeVencimento != null)
				return false;
		} else if (!dataDeVencimento.equals(other.dataDeVencimento))
			return false;
		if (numeroDaParcela != other.numeroDaParcela)
			return false;
		if (valorDaParcela == null) {
			if (other.valorDaParcela != null)
				return false;
		} else if (!valorDaParcela.equals(other.valorDaParcela))
			return false;
		return true;
	}
	
}
