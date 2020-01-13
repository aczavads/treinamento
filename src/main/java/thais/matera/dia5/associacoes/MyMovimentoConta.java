package thais.matera.dia5.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MyMovimentoConta extends BaseEntity {
	@Column(nullable = false)
//	@Enumerated(EnumType.STRING	)
	private TipoMovimentoConta tipo;
	
	@Column(nullable = false)
	private LocalDate efetuadoEm;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private String historico;
	
	public MyMovimentoConta() {
		super();
	}

	public MyMovimentoConta(TipoMovimentoConta tipo, LocalDate efetuadoEm, String historico, BigDecimal valor) {
		super();
		this.tipo = tipo;
		this.efetuadoEm = efetuadoEm;
		this.historico = historico;
		this.valor = valor;
	}

	public TipoMovimentoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentoConta tipo) {
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

	@Override
	public String toString() {
		return "MovimentoConta [tipo=" + tipo + ", efetuadoEm=" + efetuadoEm + ", valor=" + valor + ", historico="
				+ historico + "]";
	}

}
