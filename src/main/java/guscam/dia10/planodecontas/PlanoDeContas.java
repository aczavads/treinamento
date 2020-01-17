package guscam.dia10.planodecontas;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import guscam.dia10.base.BaseEntity;
import guscam.dia10.contacontabil.ContaContabil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class PlanoDeContas extends BaseEntity {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

	@ManyToMany
	@JoinTable(
			name = "conta_plano_de_contas",
			joinColumns = @JoinColumn(name = "plano_de_contas_id"), 
			inverseJoinColumns = @JoinColumn(name = "conta_contabil_id"))
	private Set<ContaContabil> contasContabeis;

	public void adicionar(ContaContabil contaContabil) {
		this.getContasContabeis().add(contaContabil);
	}

	public void remover(ContaContabil contaContabil) {
		this.getContasContabeis().remove(contaContabil);
	}
}
