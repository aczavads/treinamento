package treinamento.diegomucheniski.domains;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Correntista extends BaseEntity {
	
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

}
