package guscam.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import guscam.dia7.BaseEntity;

@Entity
public class Conta extends BaseEntity {

	@Column(nullable = false, unique = true)
	private Long numero;
	
	@Column(nullable = false)
	private LocalDate dataDeAbertura;
	
	@ManyToOne
	private Correntista correntista;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimentos = new HashSet<>();
	
	public Conta() {
		super();
	}

	public Conta(Correntista correntista, Long numero, LocalDate dataDeAbertura) {
		super();
		this.numero = numero;
		this.dataDeAbertura = dataDeAbertura;
		this.correntista = correntista;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(LocalDate dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", dataDeAbertura=" + dataDeAbertura + ", correntista=" + correntista + "]";
	}	
	
	public MovimentoConta debitar(LocalDate dataDaMovimentacao, BigDecimal valor, String historico) {
		return movimentar(dataDaMovimentacao, valor, historico, TipoMovimentoConta.DEBITO);
	}
	public MovimentoConta creditar(LocalDate dataDaMovimentacao, BigDecimal valor, String historico) {
		return movimentar(dataDaMovimentacao, valor, historico, TipoMovimentoConta.CREDITO);
	}
	
	private MovimentoConta movimentar(LocalDate dataDaMovimentacao, BigDecimal valor, String historico, TipoMovimentoConta tipo) {
		MovimentoConta movimento = new MovimentoConta(dataDaMovimentacao, valor, historico, tipo);
		this.movimentos.add(movimento);
		return movimento;
		
	}
}
