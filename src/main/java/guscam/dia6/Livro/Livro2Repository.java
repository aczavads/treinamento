package guscam.dia6.Livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Livro2Repository {
	@Autowired
	private EntityManager manager;
	
	public void save(Livro2 livro) {
		manager.persist(livro);
	}

	public void remove(Livro2 livro) {
		manager.remove(livro);
	}

	public List<Livro2> findAll() {
		return manager.createQuery("from Livro2").getResultList();
	}
}
