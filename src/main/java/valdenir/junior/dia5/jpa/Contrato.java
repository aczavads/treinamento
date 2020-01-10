package valdenir.junior.dia5.jpa;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "delete", query = "delete from Contrato") })
@Entity
public class Contrato {
	@Id
	private UUID id;
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "numero"))
	private InteiroPositivo numero;
	@Embedded
	@AttributeOverride(name = "valor", column = @Column(name = "cpfDoTitular"))
	private CPF cpfDoTitular;
	@Column(nullable = false)
	private LocalDate emissao;

	public Contrato() {
		id = UUID.randomUUID();
	}

	public Contrato(InteiroPositivo numero, CPF cpfDoTitular, LocalDate emissao) {
		this();
		this.numero = numero;
		this.cpfDoTitular = cpfDoTitular;
		this.emissao = emissao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public InteiroPositivo getNumero() {
		return numero;
	}

	public void setNumero(InteiroPositivo numero) {
		this.numero = numero;
	}

	public CPF getCpfDoTitular() {
		return cpfDoTitular;
	}

	public void setCpfDoTitular(CPF cpfDoTitular) {
		this.cpfDoTitular = cpfDoTitular;
	}

	public LocalDate getEmissao() {
		return emissao;
	}

	public void setEmissao(LocalDate emissao) {
		this.emissao = emissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", numero=" + numero + ", emissao=" + emissao + "]";
	}

}
