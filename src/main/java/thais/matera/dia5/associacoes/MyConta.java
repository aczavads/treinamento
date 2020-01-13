package thais.matera.dia5.associacoes;

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
public class MyConta extends BaseEntity {
	@Column(nullable = false, unique = true)
	private Long numero;

	@Column(nullable = false)
	private LocalDate abertaEm;
	
	@ManyToOne
	private MyCorrentista correntista;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimentacoes = new HashSet<>();
	
	public MyConta() {
		super();
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", abertaEm=" + abertaEm + ", correntista=" + correntista + "]";
	}

	public MyConta(MyCorrentista correntista, Long numero, LocalDate abertaEm) {
		super();
		this.numero = numero;
		this.abertaEm = abertaEm;
		this.correntista = correntista;
	}
	
	public MyCorrentista getCorrentista() {
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
	
	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta debito = new MovimentoConta(TipoMovimentoConta.DEBITO, efetuadoEm, historico, valor);
		movimentacoes.add(debito);
		
		return debito;
	}
	
	public MovimentoConta creditar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta creditar = new MovimentoConta(TipoMovimentoConta.CREDITO, efetuadoEm, historico, valor);
		movimentacoes.add(creditar);
		
		return creditar;
	}
	
	public MovimentoConta movimentar(LocalDate efetuadoEm, BigDecimal valor, String historico, TipoMovimentoConta tipo) {
		MovimentoConta creditar = new MovimentoConta(tipo, efetuadoEm, historico, valor);
		movimentacoes.add(creditar);
		
		return creditar;
	}
}
