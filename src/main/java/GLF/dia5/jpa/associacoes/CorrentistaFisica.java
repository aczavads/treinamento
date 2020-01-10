package GLF.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import GLF.dia5.jpa.CPF;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CorrentistaFisica extends Correntista {
	@Embedded
	@Column(unique =  true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "cpf"))
	private CPF cpfCorrentista;
	
	@Column(nullable = false)
	private LocalDate nascidaEm;
	
	public CorrentistaFisica() {
		super();
	}
	
	public CorrentistaFisica(String nome, CPF cpfCorrentista, LocalDate nascidaEm) {
		super();
		setNome(nome);
		this.cpfCorrentista = cpfCorrentista;
		this.nascidaEm = nascidaEm;
	}

	public CPF getCpfCorrentista() {
		return cpfCorrentista;
	}

	public void setCpfCorrentista(CPF cpfCorrentista) {
		this.cpfCorrentista = cpfCorrentista;
	}

	public LocalDate getNascidaEm() {
		return nascidaEm;
	}

	public void setNascidaEm(LocalDate nascidaEm) {
		this.nascidaEm = nascidaEm;
	}

	@Override
	public String toString() {
		return "CorrentistaFisica [cpfCorrentista=" + cpfCorrentista + ", nascidaEm=" + nascidaEm + ", getNome()="
				+ getNome() + "]";
	}
	
	
}
