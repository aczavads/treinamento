package william.silva.dia6.Livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LivroRepositoryWd {
	@Autowired
	private EntityManager manager;
	
	public void save(LivroWd livrowd) {
		manager.persist(livrowd);
	}
	
	public void remove (LivroWd livroWd) {
		manager.remove(livroWd);
	}
	
	public List<LivroWd> findAll(){
		return manager.createQuery("from LivroWd").getResultList();
	}

}
