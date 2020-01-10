package treinamento.dia5.jpa.associacao.fernando.santos;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class CorrentistaFisica extends Correntista {

	private static final long serialVersionUID = 2343773251192247864L;

	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "cpf"))
	private CPF cpf;

	private LocalDate nascidaEm;

	private CorrentistaFisica() {
		super(null);
	}

	public CorrentistaFisica(String nome, CPF cpf, LocalDate nascidaEm) {
		super(nome);
		this.cpf = cpf;
		this.nascidaEm = nascidaEm;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascidaEm() {
		return nascidaEm;
	}

	public void setNascidaEm(LocalDate nascidaEm) {
		this.nascidaEm = nascidaEm;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
