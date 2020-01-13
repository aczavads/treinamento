package treinamento.dia5.jpa.associacoes;

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
	private LocalDate abertaEm;
	
	@ManyToOne
	@JoinColumn(name = "correntista_id")
	private Correntista correntista;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimentos = new HashSet<>();
	
	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		return movimentar(efetuadoEm, valor, historico, TipoMovimentoConta.DEBITO);
	}
	public MovimentoConta creditar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		return movimentar(efetuadoEm, valor, historico, TipoMovimentoConta.CREDITO);
	}
	private MovimentoConta movimentar(LocalDate efetuadoEm, BigDecimal valor, String historico, TipoMovimentoConta tipo) {
		MovimentoConta movimento = new MovimentoConta(efetuadoEm, historico, valor, tipo);
		this.movimentos.add(movimento);
		return movimento;
	}
	
	public Conta() {
		super();
	}
	public Conta(Correntista correntista, Long numero, LocalDate abertaEm) {
		super();
		this.numero = numero;
		this.abertaEm = abertaEm;
		this.correntista = correntista;
		this.correntista.getContas().add(this);
	}
	public Correntista getCorrentista() {
		return correntista;
	}
	public LocalDate getAbertaEm() {
		return abertaEm;
	}
	public Long getNumero() {
		return numero;
	}
	public void setAbertaEm(LocalDate abertaEm) {
		this.abertaEm = abertaEm;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", abertaEm=" + abertaEm + ", correntista=" + correntista + "]";
	}
	

}
