package treinamento.diegomucheniski.domains;

public class Produto extends Entidade {
	
	private String nome;
	
	public Produto(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
