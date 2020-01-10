package treinamento.thyagofranco.dia5.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class MovimentoConta extends BaseEntity{
	
	@Column(nullable = false)
	private LocalDate efetuadoEm;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private String historico;
	
	@Enumerated(EnumType.STRING) // para n�o salvar no banco de dados apenas digitos e sim o DEBITO e CREDITO
	@Column(nullable = false)
	private TipoMovimentoConta tipo;
	
	public MovimentoConta() {
		
	}

	public MovimentoConta(LocalDate efetuadoEm, BigDecimal valor, String historico, TipoMovimentoConta tipo) {
		this.efetuadoEm = efetuadoEm;
		this.valor = valor;
		this.historico = historico;
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
	
	
	
	

}
