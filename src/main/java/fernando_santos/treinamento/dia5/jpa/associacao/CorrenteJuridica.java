package fernando_santos.treinamento.dia5.jpa.associacao;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class CorrenteJuridica extends Correntista {

	private static final long serialVersionUID = 682312531855251502L;

	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "cnpj"))
	private CNPJ cnpj;

	private LocalDate fundadaEm;

	public CorrenteJuridica(String nome, CNPJ cnpj, LocalDate fundadaEm) {
		super(nome);
		this.cnpj = cnpj;
		this.fundadaEm = fundadaEm;
	}

	public CNPJ getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getFundadaEm() {
		return fundadaEm;
	}

	public void setFundadaEm(LocalDate fundadaEm) {
		this.fundadaEm = fundadaEm;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
