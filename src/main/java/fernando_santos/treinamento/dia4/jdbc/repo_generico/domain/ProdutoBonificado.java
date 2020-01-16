package fernando_santos.treinamento.dia4.jdbc.repo_generico.domain;

public class ProdutoBonificado extends Produto {

	private static final long serialVersionUID = 1162307293836490310L;

	private Double percentual;

	public ProdutoBonificado(String nome) {
		super(nome);
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

}
