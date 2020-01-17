package fernando_santos.treinamento.dia10.base;

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
	REPOSITORY extends BaseRepository<ENTITY>,
	SERVICE extends BaseService<ENTITY, DTO, REPOSITORY>> {

	@Autowired
	protected SERVICE service;
	
	@GetMapping()
	public Slice<ENTITY> get(Pageable pageable) {
		return service.find(pageable);
	}

//	@GetMapping()
////	@GetMapping("/paginado")
//	public Slice<ENTITY> get(Pageable pageable, @RequestParam(defaultValue = "true", value = "asSliced") boolean asSliced) {
////	public Page<ENTITY> recuperarTodas(Pageable pageable, @RequestParam("slice") boolean slice) {
//		if (asSliced) {
//			return service.findSliced(pageable);
//		}
//		return service.findPaged(pageable);
////	}

//	@GetMapping
//	public List<ENTITY> get() {
//		return service.findAll();
//	}

	@GetMapping("/{id}")
	public ENTITY get(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public Long post(@RequestBody DTO nova) {
		ENTITY newEntity = service.save(nova);
		return newEntity.getId();
	}

	@PutMapping
	public void put(@PathVariable Long id, @RequestBody DTO dto) {
		if (!id.equals(dto.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes");
		}
		service.update(dto);
	}

//	@GetMapping("/fatiado")
//	public Slice<ContaContabil> recuperarTodasFatiadas(Pageable pageable) {
//		return service.recuperarTodasFatiadas(pageable);
//	}

}
