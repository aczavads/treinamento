package william.dia5.GenericEntity;

import java.util.HashSet;
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
		return contas;
	}


	@Override
	public String toString() {
		return "Correntista [nome=" + nome + ", contas=" + contas + "]";
	}
	

}
