package william.dia10.PlanoDeContas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import william.dia10.BaseEntity;
import william.dia10.ContaContabil.ContaContabil;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@NoArgsConstructor
public class PlanoDeContas extends BaseEntity {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "plano_de_contas_id"),
	inverseJoinColumns = @JoinColumn(name = "conta_contabil_id"))
	private Set<ContaContabil> contasContabeis = new HashSet<>();
	
	public void adicionarConta(ContaContabil contaContabil) {
		contasContabeis.add(contaContabil);
	}
	
	public void removerConta(ContaContabil contaContabil) {
		contasContabeis.remove(contaContabil);
	}
	
}
