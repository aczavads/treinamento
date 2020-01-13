package thais.matera.dia6.livro;

import javax.persistence.Entity;

import thais.matera.dia5.associacoes.BaseEntity;

@Entity
public class Livro extends BaseEntity {
	private String titulo;

	public Livro() {
		super();
	}
	
	public Livro(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
