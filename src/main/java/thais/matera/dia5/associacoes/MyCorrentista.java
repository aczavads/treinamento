package thais.matera.dia5.associacoes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MyCorrentista extends BaseEntity {
	private String nome;
	
	@OneToMany(mappedBy = "correntista")
	private Set<MyConta> contas = new HashSet<>();
	
	public MyCorrentista() {
		super();
	}
	
	public MyCorrentista(String nome) {
		super();
		this.nome = nome;
	}
	
	public Set<MyConta> getContas() {
		return Collections.unmodifiableSet(contas);
	}

	@Override
	public String toString() {
		return "Correntista [nome=" + nome + ", contas=" + contas + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
