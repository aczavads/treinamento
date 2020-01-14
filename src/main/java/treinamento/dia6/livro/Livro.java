package treinamento.dia6.livro;

import javax.persistence.Entity;

import treinamento.dia5.jpa.associacoes.BaseEntity;

@Entity
public class Livro extends BaseEntity {
	private String titulo;

	public Livro() {
		super();
	}

	public Livro(String titulo) {
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
		return "Livro [titulo=" + titulo + ", getId()=" + getId() + "]";
	}
	

}
