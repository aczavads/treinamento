package treinamento.dia6.fernando.santos.livro;

import javax.persistence.Entity;

import treinamento.dia5.jpa.associacao.fernando.santos.BaseEntity;

@Entity
public class LivroFS extends BaseEntity {
	private String titulo;

	@SuppressWarnings("unused")
	private LivroFS() {
		super();
	}

	public LivroFS(String titulo) {
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
		return "LivroFS [titulo=" + titulo + "]";
	}

}
