package thais.matera.dia5.jpa;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "delete_contrato2", query = "delete from Contrato")
})
@Entity
public class MyContrato {
	@Id
	private UUID id;
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name="cpfdotitular"))
	private CPF cpfDoTitular;
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name="numero"))
	private InteiroPositivo numero;
	
	@Column(nullable = false)
	private LocalDate emissao;
	
	public MyContrato() {
		id = UUID.randomUUID();
	}
	
	public MyContrato(InteiroPositivo numero, LocalDate emissao, CPF cpf) {
		this();
		this.numero = numero;
		this.emissao = emissao;
		System.out.println(cpf);
		this.cpfDoTitular = cpf;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", numero=" + numero + ", emissao=" + emissao + "]";
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
		MyContrato other = (MyContrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public InteiroPositivo getNumero() {
		return numero;
	}

	public void setNumero(InteiroPositivo numero) {
		this.numero = numero;
	}

	public LocalDate getEmissao() {
		return emissao;
	}

	public CPF getCpfDoTitular() {
		return cpfDoTitular;
	}

	public void setCpfDoTitular(CPF cpfDoTitular) {
		this.cpfDoTitular = cpfDoTitular;
	}

	public void setEmissao(LocalDate emissao) {
		this.emissao = emissao;
	}
	
}
