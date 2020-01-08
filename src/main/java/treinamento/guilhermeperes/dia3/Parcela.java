package treinamento.guilhermeperes.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Parcela {
	private int numero;
	private BigDecimal valor;
	private LocalDate dataVencimento;
	
	public Parcela(int numero, LocalDate dataVencimento, BigDecimal valor) {
		this.numero = numero;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Override
	public String toString() {
		return "Parcela [numero=" + numero + ", valor=" + valor + ", dataVencimento=" + dataVencimento + "]";
	}
}
