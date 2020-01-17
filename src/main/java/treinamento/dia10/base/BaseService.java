package treinamento.dia10.base;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import liquibase.logging.LoggerFactory;

public class BaseService<
		ENTITY extends BaseEntity, 
		DTO extends BaseDTO<ENTITY>, 
		REPOSITORY extends BaseRespository<ENTITY>> {
	@Autowired
	protected REPOSITORY repo;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BaseService.class);
			
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void update(DTO dto) {
		ENTITY actual = findById(dto.getId());
		actual = dto.mergeEntity(actual);
	}

	public Page<ENTITY> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public ENTITY save(DTO dto) {
		ENTITY toSave = dto.toEntity();
		return repo.save(toSave);
	}
	
	public ENTITY findById(Long id) throws RegistroNaoEncontrado {
		return repo
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Id: " + id));
	}

}





