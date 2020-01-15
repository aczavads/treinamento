package schiavon.gabriel.dia7.conta_contabil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;

public class PlanoDeContas extends BaseEntity {

	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate terminoVigencia;
	
	@ManyToMany
	private List<MyContaContabil> contasContabeis = new ArrayList<MyContaContabil>();
	
	public void adicionar(MyContaContabil cc) {
		contasContabeis.add(cc);
	}
	
	public void remover(MyContaContabil cc) {
		contasContabeis.add(cc);
	}
}
