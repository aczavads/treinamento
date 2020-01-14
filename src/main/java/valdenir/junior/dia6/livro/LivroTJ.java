package valdenir.junior.dia6.livro;

import javax.persistence.Entity;

import valdenir.junior.dia5.associacoes.BaseEntity;

@Entity
public class LivroTJ extends BaseEntity {

	private String titulo;

	public LivroTJ() {
		super();
	}

	public LivroTJ(String titulo) {
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
		return "LivroTJ [titulo=" + titulo + ", getId()=" + getId() + "]";
	}

}
