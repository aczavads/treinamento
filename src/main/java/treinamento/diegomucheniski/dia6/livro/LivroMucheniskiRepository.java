package treinamento.diegomucheniski.dia6.livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LivroMucheniskiRepository {
	
	@Autowired
	private EntityManager manager;
	
	public void save(LivroMucheniski livro) {
		manager.persist(livro);
	}
	
	public void remove(LivroMucheniski livro) {
		manager.remove(livro);
	}
	
	public List<LivroMucheniski> findAll() {
		return manager.createQuery("from LivroMucheniski").getResultList();
	}

}
