package william.dia10.ContaContabil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import william.dia10.BaseEntity;

public class BaseService<ENTITY extends BaseEntity, DTO extends BaseDTO<ENTITY>, REPOSITORY extends BaseRepository<ENTITY>> {
	
	@Autowired
	protected REPOSITORY repository;

	public List<ENTITY> findAll() {
		return repository.findAll();
	}

	public ENTITY findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void update(DTO dto) {
		ENTITY actual = findById(dto.getId());
		dto.mergeEntity(actual);
	}

	public Page<ENTITY> findAll(Pageable pageable) {
		System.out.println(pageable);
		return repository.findAll(pageable);
	}

	
	public ENTITY save(DTO dto) {
		ENTITY toSave = dto.toEntity();
		return repository.save(toSave);
	}

}
