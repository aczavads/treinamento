package treinamento.matheusfaxina.associacoes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({ @NamedQuery(name = "delete_correntista", query = "DELETE FROM Correntista") })
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Correntista extends BaseEntity {

	@Column(nullable = false)
	private String nome;

	@OneToMany(mappedBy = "correntista")
	private Set<Conta> contas = new HashSet<>();

	public Correntista() {
		super();
	}

	public Correntista(String nome) {
		this();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conta> getContas() {
		return contas;
	}
}
