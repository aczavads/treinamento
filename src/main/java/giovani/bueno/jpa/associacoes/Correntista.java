package giovani.bueno.jpa.associacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Correntista extends BaseEntity {

	private String nome;
	
	@OneToMany(mappedBy = "correntista")
    private List<Conta> contas  = new ArrayList<>();
    
	public Correntista() {
		super();
	}

	public Correntista(String nome) {
		super();
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	@Override
	public String toString() {
		return "Correntista [nome=" + nome + "]";
	}

  
}
