package diegomucheniski.domains;

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
	@NamedQuery(name = "delete_contrato", query = "delete from Contrato")
})
// @Entity
public class Contrato {

	@Id
	private UUID id;
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "valor", column = @Column(name = "numero")) // Alera o nome da coluna no db porque no embedable está como valor
	private InteiroPositivo numero;
	
	@Embedded
	@Column(unique = true, nullable = false)
	@AttributeOverride(name = "cpf", column = @Column(name = "cpf"))
	private CPFValido cpfTitular;
	
	@Column(nullable = false)
	private LocalDate emissao;
	
	public Contrato() {
		id = UUID.randomUUID();
	}

	public Contrato(InteiroPositivo numero, CPFValido cpfTitular, LocalDate emissao) {	
		this(); // Chama o construtor padrão para chamar o id e depois chama esse construtor.
		this.numero = numero;
		this.cpfTitular = cpfTitular;
		this.emissao = emissao;
	}
	
	public UUID getId() {
		return id;
	}

	public InteiroPositivo getNumero() {
		return numero;
	}

	public void setNumero(InteiroPositivo numero) {
		this.numero = numero;
	}

	public CPFValido getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(CPFValido cpfTitular) {
		this.cpfTitular = cpfTitular;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Contrato [id=");
		builder.append(id);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", cpfTitular=");
		builder.append(cpfTitular);
		builder.append(", emissao=");
		builder.append(emissao);
		builder.append("]");
		return builder.toString();
	}
		
}
