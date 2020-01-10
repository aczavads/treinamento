package treinamento.guilhermeperes.dia5.jpa.conta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import treinamento.guilhermeperes.dia5.jpa.base.BaseEntity;
import treinamento.guilhermeperes.dia5.jpa.pessoa.Pessoa;

@Entity
public class Conta extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private Integer numero;
	
	@Column(nullable = false)
	private LocalDate abertura;
	
	@ManyToOne(optional = false)
	private Pessoa pessoa;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private List<MovimentoConta> movimentos = new ArrayList<>();

	public Conta(Integer numero, LocalDate abertura, Pessoa pessoa) {
		super();
		this.numero = numero;
		this.abertura = abertura;
		this.pessoa = pessoa;
	}
	
	public Conta() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public LocalDate getAbertura() {
		return abertura;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public List<MovimentoConta> getMovimentos() {
		return Collections.unmodifiableList(movimentos);
	}
	
	private MovimentoConta movimentar(LocalDate efetuadoEm, BigDecimal valor, String descricao, TipoMovimentoConta tipo) {
		MovimentoConta movimento = new MovimentoConta(efetuadoEm, valor, tipo, descricao);
		
		movimentos.add(movimento);
		
		return movimento;
	}
	
	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String descricao) {
		return movimentar(efetuadoEm, valor, descricao, TipoMovimentoConta.DEBITO);
	}
	
	public MovimentoConta creditar(LocalDate efetuadoEm, BigDecimal valor, String descricao) {
		return movimentar(efetuadoEm, valor, descricao, TipoMovimentoConta.CREDITO);
	}
}
