package GLF.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Conta extends BaseEntity{
	
	@Column(nullable = false, unique = true)
	private Long numero;
	
	@Column(nullable = false)
	private LocalDate abertaEm;
	
	@ManyToOne
	@JoinColumn(name = "correntista_id")
	private Correntista correntista;
	
	public Conta() {
		super();
	}
	
	public Conta(Correntista correntista, Long numero, LocalDate abertaEm) {
		super();
		this.numero = numero;
		this.abertaEm = abertaEm;
		this.correntista = correntista;
		this.correntista.getConta().add(this);
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
