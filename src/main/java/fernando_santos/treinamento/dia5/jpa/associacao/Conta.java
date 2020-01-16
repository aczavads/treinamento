package fernando_santos.treinamento.dia5.jpa.associacao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Conta extends BaseEntity {

	private static final long serialVersionUID = -6398611985355426767L;

	@ManyToOne
	private Correntista correntista;

	private Long numero;
	private LocalDate abertoEm;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private Set<MovimentoConta> movimentos;

	@SuppressWarnings("unused")
	private Conta() {
//		super();
	}

	public Conta(Correntista correntista, Long numero, LocalDate abertoEm) {
		super();
		this.correntista = correntista;
		this.numero = numero;
		this.abertoEm = abertoEm;
		this.movimentos = new HashSet<>();
//		correntista.addConta(this);
	}

//	public Conta(Correntista correntista) {
//		this.correntista = correntista;
//	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getAbertoEm() {
		return abertoEm;
	}

	public void setAbertoEm(LocalDate abertoEm) {
		this.abertoEm = abertoEm;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	

}
