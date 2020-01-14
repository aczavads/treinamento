package treinamento.matheusfaxina.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "delete_movimento_conta", query = "DELETE FROM MovimentoConta") })
@Entity
public class MovimentoConta extends BaseEntity {

	private LocalDate efetuadoEm;

	private BigDecimal valor;

	private String historico;

	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipoMovimentoConta;

	private MovimentoConta() {
		super();
	}

	public MovimentoConta(LocalDate efetuadoEm, BigDecimal valor, String historico,
			TipoMovimentoConta tipoMovimentoConta) {
		this();
		this.efetuadoEm = efetuadoEm;
		this.valor = valor;
		this.historico = historico;
		this.tipoMovimentoConta = tipoMovimentoConta;
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

	public TipoMovimentoConta getTipoMovimentoConta() {
		return tipoMovimentoConta;
	}

	public void setTipoMovimentoConta(TipoMovimentoConta tipoMovimentoConta) {
		this.tipoMovimentoConta = tipoMovimentoConta;
	}

}
