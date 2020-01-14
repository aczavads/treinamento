package william.silva.dia6.Livro;

import javax.persistence.Entity;

import william.dia5.GenericEntity.BaseEntity;

@Entity
public class LivroWd extends BaseEntity{
	private String titulo;

	public LivroWd() {
		super();
	}
	
	public LivroWd(String titulo) {
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
		return "LivroWd [titulo=" + titulo + "]";
	}

	
	
	
	
}
