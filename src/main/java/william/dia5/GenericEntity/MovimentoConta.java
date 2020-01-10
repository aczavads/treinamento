package william.dia5.GenericEntity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class MovimentoConta extends BaseEntity {
	private LocalDate efetuadoEm;
	private Double valor;
	private String historico;
	@Enumerated
	private TipoMovimentoConta tipo;
	public MovimentoConta(LocalDate efetuadoEm, Double valor, TipoMovimentoConta tipo) {
		super();
		this.efetuadoEm = efetuadoEm;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public MovimentoConta() {
		
	}

	public LocalDate getEfetuadoEm() {
		return efetuadoEm;
	}

	public void setEfetuadoEm(LocalDate efetuadoEm) {
		this.efetuadoEm = efetuadoEm;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
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
