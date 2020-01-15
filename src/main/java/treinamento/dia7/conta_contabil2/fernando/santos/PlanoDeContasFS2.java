package treinamento.dia7.conta_contabil2.fernando.santos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import treinamento.dia5.jpa.associacao.fernando.santos.BaseEntity;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "plano_de_contas_fs2")
public class PlanoDeContasFS2 extends BaseEntity {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;

	@ManyToMany
	@JoinTable(
			name = "plano_de_contas_fs2_contas_contabeis_fs2",
			joinColumns = @JoinColumn(name = "plano_de_contas_fs2_id"), 
			inverseJoinColumns = @JoinColumn(name = "conta_contabil_fs2_id"))
	private Set<ContaContabilFS2> contasContabeis = new HashSet<>();

	public PlanoDeContasFS2(UUID id, String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}

}
