package william.dia10.ContaContabil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import william.dia10.BaseEntity;
import william.dia10.Exceptions.RegistroNaoEncontrado;

public class BaseService<ENTITY extends BaseEntity, DTO extends BaseDTO<ENTITY>, REPOSITORY extends BaseRepository<ENTITY>> {

	@Autowired
	protected REPOSITORY repository;

	public List<ENTITY> findAll() {
		return repository.findAll();
	}

	public ENTITY findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Registro não encontrado! ID: " + id));
	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public void update(DTO dto) {
		ENTITY actual = findById(dto.getId());
		ENTITY toSave = dto.mergeEntity(actual);
		toSave = beforeUpdate(dto, toSave);
		repository.save(toSave);
	}

	public ENTITY beforeUpdate(DTO dto, ENTITY toSave) {

		return toSave;
	}

	public Page<ENTITY> findAll(Pageable pageable) {
		System.out.println(pageable);
		return repository.findAll(pageable);
	}

	public ENTITY save(DTO dto) {
		ENTITY toSave = dto.toEntity();
		toSave = beforeUpdate(dto, toSave);
		return repository.save(toSave);
	}

}
