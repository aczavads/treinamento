package schiavon.gabriel.dia7.planoDeContas;

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
import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabil;

@Entity(name = "my_plano_de_contas")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MyPlanoDeContas extends BaseEntity {

	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate terminoVigencia;

	@ManyToMany
	@JoinTable(name = "my_conta_plano_de_contas", 
	joinColumns = @JoinColumn(name = "my_plano_de_contas_id"),
	inverseJoinColumns = @JoinColumn(name = "my_conta_contabil_id"))
	private Set<MyContaContabil> contasContabeis = new HashSet<MyContaContabil>();

	public MyPlanoDeContas(UUID id, String descricao, LocalDate inicioVigencia, LocalDate terminoVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.terminoVigencia = terminoVigencia;
	}
	
	public MyPlanoDeContas(String descricao, LocalDate inicioVigencia, LocalDate terminoVigencia) {
		super();
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.terminoVigencia = terminoVigencia;
	}

	public void adicionar(MyContaContabil cc) {
		contasContabeis.add(cc);
	}
	
	public void remover(MyContaContabil cc) {
		contasContabeis.remove(cc);
	}
}
