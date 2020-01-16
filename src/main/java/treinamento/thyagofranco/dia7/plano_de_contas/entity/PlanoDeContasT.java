package treinamento.thyagofranco.dia7.plano_de_contas.entity;

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
import treinamento.dia5.jpa.associacoes.BaseEntity;
import treinamento.thyagofranco.dia7.conta_contabil.entities.ContaContabilThyago;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlanoDeContasT extends BaseEntity{
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	
	@ManyToMany
	@JoinTable(
			name = "conta_plano_de_contas",
			joinColumns = @JoinColumn(name = "plano_decontas_id"),
			inverseJoinColumns = @JoinColumn(name = "conta_contabil_id"))
	private Set<ContaContabilThyago> contasContabeis = new HashSet<>();
	
	public PlanoDeContasT(UUID id, String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}
	
	public void adicionar (ContaContabilThyago contaContabil) {
		
		this.getContasContabeis().add(contaContabil);
			
	}

	
}
