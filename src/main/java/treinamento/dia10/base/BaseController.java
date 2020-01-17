package treinamento.dia10.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class BaseController<
			ENTITY extends BaseEntity, 
			DTO extends BaseDTO<ENTITY>, 
			REPOSITORY extends BaseRespository<ENTITY>,
			SERVICE extends BaseService<ENTITY, DTO, REPOSITORY>> {
	@Autowired 
	protected SERVICE service;
	
	@GetMapping("/{id}")
	public ENTITY get(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable Long id, @RequestBody DTO dto) {
		if (!id.equals(dto.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes!");
		}
		service.update(dto);
	}
	@PostMapping
	public Long post(@RequestBody DTO dto) {
		ENTITY newEntity = service.save(dto);
		return newEntity.getId();
	}

	@GetMapping
	public Slice<ENTITY> get(Pageable pageable) {
		return service.findAll(pageable);
	}

}



