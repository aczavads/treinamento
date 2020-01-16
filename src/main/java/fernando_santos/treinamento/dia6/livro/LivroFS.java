package fernando_santos.treinamento.dia6.livro;

import javax.persistence.Entity;

import fernando_santos.treinamento.dia5.jpa.associacao.BaseEntity;

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
