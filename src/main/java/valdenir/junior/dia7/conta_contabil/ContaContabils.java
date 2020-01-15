package valdenir.junior.dia7.conta_contabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import valdenir.junior.dia5.associacoes.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ContaContabils extends BaseEntity {
	private String codigo;
	private String nome;
	@JsonIgnore
	@ManyToOne
	private ContaContabils contaSuperior;
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabils> contasFilha;

	public ContaContabils() {
		super();
	}

	public ContaContabils(String codigo, String nome, ContaContabils contaContabil) {
		this();
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaContabil;
	}

	@Override
	public String toString() {
		return "ContaContabils [codigo=" + codigo + ", nome=" + nome + ", contaContabil=" + contaSuperior + ", getId()="
				+ getId() + "]";
	}

}
