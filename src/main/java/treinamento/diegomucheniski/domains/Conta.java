package treinamento.diegomucheniski.domains;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Conta extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private Long numero;
	
	@Column(nullable = false)
	private LocalDate abertaEm;
	
	@ManyToOne
	private Correntista correntista;
	
	public Conta() {
		super();
	}

	public Conta(Long numero, LocalDate abertaEm, Correntista correntista) {
		super();
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
