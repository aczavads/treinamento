package treinamento.diegomucheniski.dia7.plano_de_contas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import treinamento.diegomucheniski.dia7.conta_contabil.ContaContabilMucheniski;
import treinamento.diegomucheniski.domains.BaseEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Chama o equals e hashCode do BaseEntity
@NoArgsConstructor
public class PlanoDeContasMucheniski extends BaseEntity {
	
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;	
	
	@ManyToMany
	@JoinTable(
			name="conta_plano_de_contas_mucheniski",
			joinColumns = @JoinColumn(name = "plano_de_contas_id"),
			inverseJoinColumns = @JoinColumn(name = "conta_contabil_id")
	)
	private Set<ContaContabilMucheniski> contasContabeis = new HashSet<>();
	
	public PlanoDeContasMucheniski(UUID id, String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}
	
	public void adicionarConta(ContaContabilMucheniski conta) {
		contasContabeis.add(conta);
	}
	
	public void removerConta(ContaContabilMucheniski conta) {
		contasContabeis.remove(conta);
	}

}
