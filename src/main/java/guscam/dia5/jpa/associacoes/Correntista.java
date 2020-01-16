package guscam.dia5.jpa.associacoes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import guscam.dia7.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Correntista extends BaseEntity {
	private String nome;

	@OneToMany(mappedBy = "correntista")
	private Set<Conta> contas = new HashSet<>();

	public Correntista() {
		super();
	}

	public Correntista(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conta> getContas() {
		return Collections.unmodifiableSet(contas);
	}

	@Override
	public String toString() {
		return "Correntista [nome=" + nome + "]";
	}
}
