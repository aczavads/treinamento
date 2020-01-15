package thais.matera.dia7.conta_contabil.plano;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import thais.matera.dia5.associacoes.BaseEntity;
import thais.matera.dia7.conta_contabil.ContaContabil;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlanoDeContas extends BaseEntity {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	
//	private List<ContaContabil> contas;
	
	public PlanoDeContas(UUID id, String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super(id);
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}
	
	public PlanoDeContas(String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super();
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}

	public void adicionar(ContaContabil conta) {
		
	}
	
	public void remover(ContaContabil conta) {
		
	}

//	public List<ContaContabil> getContas() {
//		return contas;
//	}
//
//	public void setContas(List<ContaContabil> contas) {
//		this.contas = contas;
//	}
	
	
}
