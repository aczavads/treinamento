package guscam.dia10.base;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Transactional
public class BaseService<ENTITY extends BaseEntity, DTO extends BaseDTO<ENTITY>, REPOSITORY extends BaseRepository<ENTITY>> {
	@Autowired
	protected REPOSITORY repository;

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public void update(DTO dto) {
		ENTITY actual = findById(dto.getId());
		dto.mergeEntity(actual);
	}

	public ENTITY save(DTO dto) {
		ENTITY entity = dto.toEntity();
		return repository.save(entity);
	}
	
	public ENTITY findById(Long id) throws RegistroNaoEncontrado {
		return repository
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Id: " + id));
	}

	public Page<ENTITY> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
