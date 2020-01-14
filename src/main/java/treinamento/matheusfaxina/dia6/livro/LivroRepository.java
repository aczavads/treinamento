package treinamento.matheusfaxina.dia6.livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LivroRepository {

	@Autowired
	private EntityManager manager;

	public void save(Livro livro) {
		manager.persist(livro);
	}
	
	public void remove(Livro livro) {
		manager.remove(livro);
	}
	
	public List<Livro> findAll() {
		return manager.createQuery("FROM Livro").getResultList();
	}

}
