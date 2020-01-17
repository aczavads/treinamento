package schiavon.gabriel.dia7.planoDeContas;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabil;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString
@NoArgsConstructor
public class MyPlanoDeContas extends BaseEntity {

	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate terminoVigencia;

	@ManyToMany
	@JoinTable(name = "my_conta_plano_de_contas", joinColumns = @JoinColumn(name = "my_plano_de_contas_id"), inverseJoinColumns = @JoinColumn(name = "my_conta_contabil_id"))
	private Set<MyContaContabil> contasContabeis;

	public void adicionar(MyContaContabil cc) {
		contasContabeis.add(cc);
	}

	public void remover(MyContaContabil cc) {
		contasContabeis.remove(cc);
	}
}
