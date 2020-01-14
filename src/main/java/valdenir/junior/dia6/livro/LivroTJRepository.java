package valdenir.junior.dia6.livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LivroTJRepository {

	@Autowired
	private EntityManager em;

	public void safe(LivroTJ livroTJ) {
		em.persist(livroTJ);
	}

	public void remove(LivroTJ livroTJ) {
		em.remove(livroTJ);
	}

	public List<LivroTJ> findAll() {
		return em.createQuery("from LivroTJ", LivroTJ.class).getResultList();
	}
}
