package william.dia5.GenericEntity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Conta extends BaseEntity{
	@Column(nullable = false, unique = true)
	private Long numero;
	@Column(nullable = false)
	private LocalDate dataAbertura;
	
	@ManyToOne
	private Correntista correntista;
	
	public Conta(Correntista correntista,Long numero, LocalDate dataAbertura) {
		super();
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.correntista = correntista;
	}
	
	public Conta() {
		super();
	}
	

	
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
