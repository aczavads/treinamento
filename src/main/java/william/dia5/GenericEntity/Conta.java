package william.dia5.GenericEntity;

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
	private LocalDate dataAbertura;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private List<MovimentoConta> movimentos = new ArrayList<>();

	@ManyToOne
	private Correntista correntista;

	public Conta(Correntista correntista, Long numero, LocalDate dataAbertura) {
		super();
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.correntista = correntista;
	}
	
	public void creditar(Double valor) {
		this.movimentos.add(new MovimentoConta(LocalDate.now(),valor, TipoMovimentoConta.CREDITO));
	}
	
	public void debitar(Double valor) {
		this.movimentos.add(new MovimentoConta(LocalDate.now(),valor, TipoMovimentoConta.DEBITO));
	}

	public Conta() {
		super();
	}
//
//	public List<MovimentoConta> getMovimentos() {
//		return movimentos;
//	}

	public Conta(Long numero, LocalDate dataAbertura, Correntista correntista) {
		super();
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.correntista = correntista;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

}
