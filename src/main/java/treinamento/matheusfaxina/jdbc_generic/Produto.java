package treinamento.matheusfaxina.jdbc_generic;

public class Produto extends Entidade {

	private Integer codigo;
	private String nome;

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
