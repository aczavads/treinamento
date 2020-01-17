package fernando_santos.treinamento.dia10.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public class BaseService<
	ENTITY extends BaseEntity, 
	DTO extends BaseDTO<ENTITY>, 
	REPOSITORY extends BaseRepository<ENTITY>> {

	@Autowired
	protected REPOSITORY repo;

//	public List<ENTITY> findAll() {
//		return repo.findAll();
//	}

//	public Page<ENTITY> findPaged(Pageable pageable) {
//		return null;
//	}
	

	public Slice<ENTITY> find(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public ENTITY findById(Long id) throws RegistroNaoEncontrado {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("ID: " + id));
	}

	public ENTITY save(DTO dto) {
		ENTITY toSave = dto.toEntity();
		return repo.save(toSave);
	}

	public void update(DTO dto) {
		ENTITY actual = findById(dto.getId());
		dto.mergeEntity(actual);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);

	}

}
