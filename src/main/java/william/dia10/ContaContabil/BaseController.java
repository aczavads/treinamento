package william.dia10.ContaContabil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import william.dia10.BaseEntity;
import william.dia7.Conta_Contabilwd.ContaNãoEncontrada;

public class BaseController<
		ENTITY extends BaseEntity,
		DTO extends BaseDTO<ENTITY>,
		REPOSITORY extends BaseRepository<ENTITY>,
		SERVICE extends BaseService<ENTITY,
		DTO, REPOSITORY>> {
	@Autowired
	protected SERVICE service;

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
		service.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody DTO dto) {
		if (!id.equals(dto.getId())) {
			throw new ContaNãoEncontrada("ID's divergentes!");
		}
		service.update(dto);
	}

	@PostMapping
	public Long post(@RequestBody DTO dto) {
		ENTITY newInstance = service.save(dto);
		return newInstance.getId();
	}

	@GetMapping
	public Slice<ENTITY> get(Pageable pageable) {

		return service.findAll(pageable);
	}
}
