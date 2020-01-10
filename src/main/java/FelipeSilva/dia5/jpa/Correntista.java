package FelipeSilva.dia5.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Correntista extends BaseEntity {
	private String nome;

	@OneToMany(mappedBy = "correntista")
	private List<Conta> contas = new ArrayList<>();

	public Correntista() {
		super();
	}

	public Correntista(String nome) {
		super();
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Correntista [nome=" + nome + "]";
	}

}
