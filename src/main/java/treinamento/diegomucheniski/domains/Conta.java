package treinamento.diegomucheniski.domains;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import treinamento.diegomucheniski.enums.TipoMovimentoConta;

@Entity
public class Conta extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private Long numero;
	
	@Column(nullable = false)
	private LocalDate abertaEm;
	
	@ManyToOne
	private Correntista correntista;	
	
	@OneToMany()
	@JoinColumn(name = "conta_id")
	Set<MovimentoConta> movimentos = new HashSet<>();
	
	public Conta() {
		super();
	}

	public Conta(Long numero, LocalDate abertaEm, Correntista correntista) {
		super();
		this.numero = numero;
		this.abertaEm = abertaEm;
		this.correntista = correntista;
	}
	
	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta debito = new MovimentoConta(efetuadoEm, valor, historico, TipoMovimentoConta.DEBITO);
		this.movimentos.add(debito);
		return debito;
	}
	
	public MovimentoConta creditar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		MovimentoConta credito = new MovimentoConta(efetuadoEm, valor, historico, TipoMovimentoConta.CREDITO);
		this.movimentos.add(credito);
		return credito;
	}
	
	public MovimentoConta movimentar(LocalDate efetuadoEm, BigDecimal valor, String historico, TipoMovimentoConta tipo) {
		MovimentoConta movimento = new MovimentoConta(efetuadoEm, valor, historico, tipo);
		this.movimentos.add(movimento);
		return movimento;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [numero=");
		builder.append(numero);
		builder.append(", abertaEm=");
		builder.append(abertaEm);
		builder.append(", correntista=");
		builder.append(correntista);
		builder.append("]");
		return builder.toString();
	}

}
