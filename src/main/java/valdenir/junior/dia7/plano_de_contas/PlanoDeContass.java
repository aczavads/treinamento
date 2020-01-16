package valdenir.junior.dia7.plano_de_contas;

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
import valdenir.junior.dia5.associacoes.BaseEntity;
import valdenir.junior.dia7.conta_contabil.ContaContabils;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class PlanoDeContass extends BaseEntity {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

	@ManyToMany
	@JoinTable(name = "conta_plano_de_contass", joinColumns = @JoinColumn(name = "plano_de_contas_id"), inverseJoinColumns = @JoinColumn(name = "conta_contabils_id"))
	private Set<ContaContabils> contasContabeis = new HashSet<>();

	public PlanoDeContass(UUID id, String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}

	public void adicionar(ContaContabils cc) {
		this.getContasContabeis().add(cc);
	}

	public void remover(ContaContabils cc) {
		this.getContasContabeis().remove(cc);
	}
}
