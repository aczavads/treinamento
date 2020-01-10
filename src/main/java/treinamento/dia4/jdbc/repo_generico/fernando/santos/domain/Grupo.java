package treinamento.dia4.jdbc.repo_generico.fernando.santos.domain;

import java.time.LocalDate;

public class Grupo extends BaseEntity {

	private static final long serialVersionUID = 5872149805466621189L;

	private String descricao;
	private LocalDate dataDeFundacao;

	public Grupo(String descricao, LocalDate dataDeFundacao) {
		super();
		this.descricao = descricao;
		this.dataDeFundacao = dataDeFundacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

}
