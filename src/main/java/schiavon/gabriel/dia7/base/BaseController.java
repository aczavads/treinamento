package schiavon.gabriel.dia7.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;

public class BaseController<ID, ENTIDADE extends BaseEntity<ID>, DTO extends BaseDTO<ID, ENTIDADE>, REPOSITORY extends BaseRepository<ID, ENTIDADE>, SERVICE extends BaseService<ID, ENTIDADE, DTO, REPOSITORY>> {

	@Autowired
	protected SERVICE service;

	@GetMapping("/paginado-manual")
	public List<ENTIDADE> getPaginadoManual(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.recuperarTodasManual(page, size);
	}

	@GetMapping
	public Slice<ENTIDADE> getPaginadoPorSlice(Pageable pageable) {
		return service.findAll(pageable);
	}

	@PostMapping
	public ID post(@RequestBody DTO novaContaDTO) {
		return service.save(novaContaDTO).getId();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ENTIDADE> getById(@PathVariable ID id) {
		ENTIDADE contaContabil = service.findById(id);
		return ResponseEntity.ok(contaContabil);
	}

	@GetMapping("/quantidade")
	public Long getQuantidadeContas() {
		return service.getQuantidade();
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable ID id) {
		service.remover(id);
	}

	@PutMapping("/{id}")
	public void alterarPlano(@PathVariable ID id, @RequestBody DTO contaContabilDTO) {
		service.update(id, contaContabilDTO);
	}
}
