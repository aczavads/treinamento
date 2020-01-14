package treinamento.thyagofranco.dia6.livro;

import javax.persistence.Entity;

import treinamento.thyagofranco.dia5.associacoes.BaseEntity;
@Entity
public class LivroThyago extends BaseEntity{
	
	private String titulo;
	
	public LivroThyago() {
		super();
	}
	
	public LivroThyago(String titulo) {
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LivroThyago [titulo=");
		builder.append(titulo);
		builder.append(", ID=");
		builder.append(getId());
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
