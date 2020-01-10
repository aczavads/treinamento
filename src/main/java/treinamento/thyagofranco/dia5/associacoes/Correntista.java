package treinamento.thyagofranco.dia5.associacoes;

import java.util.Collections;
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
	
	//Para não permitir uma conta duplicada utilizamos Set
	//Um correntista para muitas contas
	
	@OneToMany(mappedBy = "correntista")
	private Set<Conta> contas = new HashSet<>();
	
	public Correntista() {
		super();		
	}
	
	public Correntista(String nome) {
		super();
		this.nome = nome;
	}
	
	public Set<Conta> getContas(){
		return Collections.unmodifiableSet(contas);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Correntista [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

	

}
