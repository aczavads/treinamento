package valdenir.junior.dia5.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	private Correntista correntista;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "contaid")
	private List<MovimentoConta> movimentos = new ArrayList<>();

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

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public MovimentoConta creditar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		return movimentar(efetuadoEm, valor, historico, TipoMovimentoConta.CREDITO);
	}

	private MovimentoConta movimentar(LocalDate efetuadoEm, BigDecimal valor, String historico,
			TipoMovimentoConta tipo) {
		MovimentoConta mc = new MovimentoConta(efetuadoEm, valor, historico, tipo);
		movimentos.add(mc);
		return mc;
	}

	public MovimentoConta debitar(LocalDate efetuadoEm, BigDecimal valor, String historico) {
		return movimentar(efetuadoEm, valor, historico, TipoMovimentoConta.DEBITO);
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", abertaEm=" + abertaEm + ", correntista=" + correntista.getNome()
				+ ", movimentoConta= " + movimentos + "]";
	}

}
