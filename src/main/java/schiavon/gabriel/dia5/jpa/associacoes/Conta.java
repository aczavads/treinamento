package schiavon.gabriel.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conta extends BaseEntity {

	@Column(nullable = false, unique = true)
	private Long numero;

	@Column(nullable = false)
	private LocalDate abertoEm;

	@ManyToOne
	private Correntista correntista;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimentos = new HashSet<>();

	public Conta() {
		super();
	}

	public Conta(Long numero, LocalDate abertoEm, Correntista correntista) {
		super();
		this.numero = numero;
		this.abertoEm = abertoEm;
		this.correntista = correntista;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getAbertoEm() {
		return abertoEm;
	}

	public void setAbertoEm(LocalDate abertoEm) {
		this.abertoEm = abertoEm;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public MovimentoConta movimentar(LocalDate efetuadoEm, BigDecimal valor, String historico, TipoMovimentoConta tipoMovimentoConta) {
		MovimentoConta debito = new MovimentoConta(efetuadoEm, valor, historico, tipoMovimentoConta);
		this.movimentos.add(debito);
		return debito;
	}
}
