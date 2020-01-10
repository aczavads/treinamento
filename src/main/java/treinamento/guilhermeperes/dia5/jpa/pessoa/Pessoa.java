package treinamento.guilhermeperes.dia5.jpa.pessoa;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import treinamento.guilhermeperes.dia5.jpa.base.BaseEntity;
import treinamento.guilhermeperes.dia5.jpa.conta.Conta;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String nome;

	@OneToMany(mappedBy = "pessoa")
	private Set<Conta> contas = new HashSet<>();

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}
	
	public Pessoa() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public Set<Conta> getContas() {
		return Collections.unmodifiableSet(contas);
	}
}
