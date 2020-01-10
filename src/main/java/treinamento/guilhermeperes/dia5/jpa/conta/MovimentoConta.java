package treinamento.guilhermeperes.dia5.jpa.conta;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import treinamento.guilhermeperes.dia5.jpa.base.BaseEntity;

@Entity
public class MovimentoConta extends BaseEntity {
	
	@Column(nullable = false)
	private LocalDate efetuadoEm;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoMovimentoConta tipo;
	
	@Column
	private String descricao;

	public MovimentoConta(LocalDate efetuadoEm, BigDecimal valor, TipoMovimentoConta tipo, String descricao) {
		super();
		this.efetuadoEm = efetuadoEm;
		this.valor = valor;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public MovimentoConta() {
		super();
	}

	public LocalDate getEfetuadoEm() {
		return efetuadoEm;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public TipoMovimentoConta getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
