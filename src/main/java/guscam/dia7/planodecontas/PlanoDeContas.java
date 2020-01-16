package guscam.dia7.planodecontas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import guscam.dia7.BaseEntity;
import guscam.dia7.contacontabil.ContaContabil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
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
	private Set<ContaContabil> contasContabeis = new HashSet<>();

	public PlanoDeContas(UUID id, String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}

	public void adicionarConta(ContaContabil conta) {
		this.contasContabeis.add(conta);
	}

	public void removerConta(ContaContabil conta) {
		this.contasContabeis.remove(conta);
	}
}
