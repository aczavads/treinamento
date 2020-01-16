package fernando_santos.treinamento.dia4.jdbc.repo_generico.domain;

public class Produto extends BaseEntity {

	private static final long serialVersionUID = 8437499380986709279L;

	private String nome;

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
