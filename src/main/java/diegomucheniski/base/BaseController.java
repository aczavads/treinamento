package diegomucheniski.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<
				ENTITY extends BaseEntity, 
				DTO extends BaseDTO<ENTITY>, 
				REPOSITORY extends BaseRepository<ENTITY>, 
				SERVICE extends BaseService<ENTITY, DTO, REPOSITORY>> {

	@Autowired
	protected SERVICE service;
	
	@GetMapping
	public Page<ENTITY> findAll(Pageable pageable) {
		return service.findAll(pageable);		
	}
	
	@GetMapping("/{id}")
	public ENTITY findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Long save(@RequestBody DTO dto) {	
		ENTITY newEntity = service.save(dto);
		return newEntity.getId();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody DTO dto) {
		if (!id.equals(dto.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes!");
		}
		service.update(dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
	
}
