package thyagofranco.dia6.livro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LivroThyagoRepository {

	@Autowired // não é mais necessidade de passar o EntityManager pelo construtor.
	private EntityManager manager;

	public void save(LivroThyago livro) {
		manager.persist(livro);
	}
	
	public void remove(LivroThyago livro) {
		manager.remove(livro);
	}
	
	public List<LivroThyago> findAll(){
		return manager.createQuery("from LivroThyago").getResultList();
	}
}	
