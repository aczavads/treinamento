package treinamento.dia7.plano_de_contas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import treinamento.dia5.jpa.associacoes.BaseEntity;
import treinamento.dia7.conta_contabil.ContaContabil;

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
}
