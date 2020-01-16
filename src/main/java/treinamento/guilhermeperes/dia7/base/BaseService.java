package treinamento.guilhermeperes.dia7.base;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.guilhermeperes.dia7.base.exceptions.NotFoundedException;

public abstract class BaseService<
		ENTITY extends BaseEntity,
		REPOSITORY extends BaseRepository<ENTITY>> {
	
	@Autowired
	private REPOSITORY repo;
	
	private void checkEntityNotExists(UUID id) {
		if(!repo.existsById(id)) {
			throw new NotFoundedException("Cannot find Entity with provided id");
		}
	}
	
	public UUID save(ENTITY entity) {
		return repo
				.save(entity)
				.getId();
	}
	
	public UUID updateById(ENTITY entity) {
		checkEntityNotExists(entity.getId());
		
		return repo
				.save(entity)
				.getId();
	}
	
	public void deleteById(ENTITY entity) {
		checkEntityNotExists(entity.getId());
		
		repo.delete(entity);
	}
	
	public List<ENTITY> findAll() {
		return repo.findAll();
	}
	
	public ENTITY findById(UUID id) {
		return repo
				.findById(id)
				.orElseThrow(() -> new NotFoundedException("Cannot find Entity with provided id"));
	}
}
