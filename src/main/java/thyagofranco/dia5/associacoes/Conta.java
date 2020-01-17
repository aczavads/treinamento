package thyagofranco.dia5.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
	private LocalDate abertaEm;

	@ManyToOne
	// Muitas contas para um correntista
	private Correntista correntista;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimento = new HashSet<>();

	public Conta() {
		super();
	}

	public Conta(Correntista correntista, Long numero, LocalDate abertaEm) {
		super();
		this.numero = numero;
		this.abertaEm = abertaEm;
		this.correntista = correntista;
	}

	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta debito = new MovimentoConta(efetuadoEm, valor, historico, TipoMovimentoConta.DEBITO);
		this.movimento.add(debito);
		return debito;
	}

	public MovimentoConta creditar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta credito = new MovimentoConta(efetuadoEm, valor, historico, TipoMovimentoConta.CREDITO);
		this.movimento.add(credito);
		return credito;
	}
	
	public Correntista getCorretinta() {
		return correntista;
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

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", abertaEm=" + abertaEm + ", correntista=" + correntista + "]";
	}

}
