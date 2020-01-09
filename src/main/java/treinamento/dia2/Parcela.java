package treinamento.dia2;

import java.math.BigDecimal;

import java.time.LocalDate;

public class Parcela {
	private int numero;
	private LocalDate vencimento;
	private BigDecimal valor;
	
	
	/*
	@Override
	public String toString() {
		return "Parcela nro " + numero + " com vencimento em " + vencimento + " no valor de " + valor;
	}
	*/
	
	@Override
	public String toString() {
		return "Parcela [numero=" + numero + ", vencimento=" + vencimento + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((vencimento == null) ? 0 : vencimento.hashCode());
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
		if (numero != other.numero)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (vencimento == null) {
			if (other.vencimento != null)
				return false;
		} else if (!vencimento.equals(other.vencimento))
			return false;
		return true;
	}

	public Parcela(int numero, LocalDate vencimento, BigDecimal valor) {
		this.numero = numero;
		this.vencimento = vencimento;
		this.valor = valor;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

}
