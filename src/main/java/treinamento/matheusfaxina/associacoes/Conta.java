package treinamento.matheusfaxina.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({ @NamedQuery(name = "delete_conta", query = "DELETE FROM Conta") })
@Entity
public class Conta extends BaseEntity {

	@Column(nullable = false, unique = true)
	private Long numero;

	@Column(nullable = false)
	private LocalDate abertaEm;

	@ManyToOne
	private Correntista correntista;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimentos = new HashSet<>();

	public Conta() {
		super();
	}

	public Conta(Long numero, LocalDate abertaEm, Correntista correntista) {
		this();
		this.numero = numero;
		this.abertaEm = abertaEm;
		this.correntista = correntista;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getAbertaEm() {
		return abertaEm;
	}

	public void setAbertaEm(LocalDate abertaEm) {
		this.abertaEm = abertaEm;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public Set<MovimentoConta> getMovimentos() {
		return movimentos;
	}

	public MovimentoConta creditar(LocalDate abertoEm, BigDecimal valor, String historico) {
		MovimentoConta movimentoConta =  new MovimentoConta(abertoEm, valor, historico, TipoMovimentoConta.CREDITO);
		movimentos.add(movimentoConta);
		return movimentoConta;
	}

	public MovimentoConta debitar(LocalDate abertoEm, BigDecimal valor, String historico) {
		MovimentoConta movimentoConta = new MovimentoConta(abertoEm, valor, historico, TipoMovimentoConta.DEBITO);
		movimentos.add(movimentoConta);
		return movimentoConta;
	}

}
