package thais.matera.dia7.conta_contabil.plano;

import java.time.LocalDate;

import thais.matera.dia5.associacoes.BaseEntity;
import thais.matera.dia7.conta_contabil.ContaContabil;

public class PlanoDeContas extends BaseEntity {
	private String descricao;
	private LocalDate inicioVigencia;
	private LocalDate fimVigencia;
	
	public PlanoDeContas(String descricao, LocalDate inicioVigencia, LocalDate fimVigencia) {
		super();
		this.descricao = descricao;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(LocalDate inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public LocalDate getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(LocalDate fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public void adicionar(ContaContabil conta) {
		
	}
	
	public void remover(ContaContabil conta) {
		
	}
}
