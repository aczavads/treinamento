package schiavon.gabriel.dia5.jpa;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//@NamedQueries({ @NamedQuery(name = "delete_contrato1", query = "delete from Contrato") })
//@Entity
public class Contrato {

	@Id
	private UUID id;

	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "numero"))
	private IntegerPositivo numero;

	@Column(nullable = false)
	private LocalDate emissao;

	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "cpf"))
	private CPF cpfTitular;

	public Contrato() {
		id = UUID.randomUUID();
	}

	public Contrato(IntegerPositivo numero, LocalDate emissao, CPF cpf) {
		this();
		this.numero = numero;
		this.emissao = emissao;
		this.cpfTitular = cpf;
	}

	public LocalDate getEmissao() {
		return emissao;
	}

	public void setEmissao(LocalDate emissao) {
		this.emissao = emissao;
	}

	public UUID getId() {
		return id;
	}

	public IntegerPositivo getNumero() {
		return numero;
	}

	public void setNumero(IntegerPositivo numero) {
		this.numero = numero;
	}

	public CPF getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(CPF cpfTitular) {
		this.cpfTitular = cpfTitular;
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
		return "Contrato [id=" + id + ", numero=" + numero + ", emissao=" + emissao + ", cpfTitular=" + cpfTitular
				+ "]";
	}
}
