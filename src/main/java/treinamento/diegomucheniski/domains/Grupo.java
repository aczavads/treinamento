package treinamento.diegomucheniski.domains;

import java.time.LocalDate;

public class Grupo extends Entidade {
	
	private String descricao;
	private LocalDate dataFundacao;
	
	public Grupo(String descricao, LocalDate dataFundacao) {
		super();
		this.descricao = descricao;
		this.dataFundacao = dataFundacao;		
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
}
