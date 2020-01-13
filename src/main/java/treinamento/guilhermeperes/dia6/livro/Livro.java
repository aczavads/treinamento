package treinamento.guilhermeperes.dia6.livro;

import javax.persistence.Entity;

import treinamento.guilhermeperes.dia6.base.BaseEntity;

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

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + "]";
	}
}
