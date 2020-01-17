package treinamento.dia10.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import treinamento.dia10.conta_contabil.ContaContabil;

public class BaseService<
		ENTITY extends BaseEntity, 
		DTO extends BaseDTO, 
		REPOSITORY extends BaseRespository<ENTITY>> {
	@Autowired
	protected REPOSITORY repo;

	public List<ENTITY> findAll() {
		return repo.findAll();
	}

	public ENTITY findById(Long id) {
		return null;
	}

	public void deleteById(Long id) {
		
	}

	public void update(DTO dto) {
	}

	public Slice<ENTITY> findSliced(Pageable pageable) {
		return null;
	}

	public Page<ENTITY> findPaged(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public ENTITY save(DTO dto) {
		ENTITY toSave = prepareEntityToSave(dto);
		return repo.save(toSave);
	}

	private ENTITY prepareEntityToSave(DTO dto) {
		return dto.toEntity();
	}

}
