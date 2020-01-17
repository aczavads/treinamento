package diegomucheniski.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import diegomucheniski.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Chama o equals e hashCode do BaseEntity
@NoArgsConstructor
@SuperBuilder
public class PlanoDeContas extends BaseEntity {
	
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;	
	
	@ManyToMany
	@JoinTable(
			name="conta_plano_de_contas",
			joinColumns = @JoinColumn(name = "plano_de_contas_id"),
			inverseJoinColumns = @JoinColumn(name = "conta_contabil_id")
	)
	private Set<ContaContabil> contasContabeis = new HashSet<>();

	public void adicionarConta(ContaContabil conta) {
		contasContabeis.add(conta);
	}
	
	public void removerConta(ContaContabil conta) {
		contasContabeis.remove(conta);
	}

}
