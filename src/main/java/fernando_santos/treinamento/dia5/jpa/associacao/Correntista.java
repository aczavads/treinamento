package fernando_santos.treinamento.dia5.jpa.associacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Correntista extends BaseEntity {

	private static final long serialVersionUID = 2021965132727964178L;

	private String nome;

	@OneToMany(mappedBy = "correntista")
	private Set<Conta> contas;

	@SuppressWarnings("unused")
	private Correntista() {
//		super();
	}

	public Correntista(String nome) {
		super();
		this.nome = nome;
		this.contas = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conta> getAllContas() {
		return Collections.unmodifiableSet(contas);
	}

	public Conta getConta(Conta conta) {
		Optional<Conta> contaEncontrada = contas.stream().filter(c -> c.equals(conta)).findAny();
		if (contaEncontrada.isPresent()) {
			return contaEncontrada.get();
		}
		return null;
	}

	public Boolean addConta(Conta conta) {
		return contas.add(conta);
	}

	public Boolean removeConta(Conta conta) {
		return contas.remove(conta);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
