package fernando_santos.treinamento.dia6.livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LivroRepositoryFS {

	@Autowired
	private EntityManager entityManager;
	
	public void save(LivroFS livro) {
		entityManager.persist(livro);
	}
	
	public void remove(LivroFS livro) {
		entityManager.remove(livro);
	}
	
	public List<LivroFS> findAll() {
		return entityManager.createQuery("from LivroFS", LivroFS.class).getResultList();
	}
}
