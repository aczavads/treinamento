package treinamento.guilhermeperes.dia7.base;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import treinamento.guilhermeperes.dia7.base.exceptions.NotFoundedException;

public abstract class BaseService<
		ENTITY extends BaseEntity,
		REPOSITORY extends JpaRepository<ENTITY, UUID>> {
	
	@Autowired
	private REPOSITORY repo;
	
	public void save(ENTITY entity) {
		repo.save(entity);
	}
	
	public void deleteById(ENTITY entity) {
		repo.delete(entity);
	}
	
	public List<ENTITY> findAll() {
		return repo.findAll();
	}
	
	public ENTITY findById(UUID id) {
		return repo.findById(id)
				.orElseThrow(() -> new NotFoundedException("Cannot find Conta with provided id"));
	}
}
