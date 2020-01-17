package diegomucheniski.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import diegomucheniski.services.exceptions.RegistroNaoEncontrado;

public class BaseService<ENTITY extends BaseEntity, DTO extends BaseDTO<ENTITY>, REPOSITORY extends BaseRepository<ENTITY>> {
	
	@Autowired
	protected REPOSITORY repository;
	
	public Page<ENTITY> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public ENTITY findById(Long id) throws RegistroNaoEncontrado {
		return repository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Registro não encontrado com o id: " + id));
	}	
	
	public ENTITY save(DTO dto) {	
		ENTITY toSave = dto.toEntity();
		return repository.save(toSave);
	}

	// Como o service é transactional esse método abre uma transação e salva as alterações automáticamente pelo JPA
	public void update(DTO dto) {
		ENTITY actual = findById(dto.getId());
		ENTITY toSave = dto.mergeEntity(actual);		
		repository.save(toSave);
	}

	public void deleteById(Long id) {	
		repository.deleteById(id);
	}	
	
}
