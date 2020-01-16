package treinamento.guilhermeperes.dia7.base;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import treinamento.guilhermeperes.dia7.utils.Id;

public abstract class BaseController<
		ENTITY extends BaseEntity,
		REPOSITORY extends BaseRepository<ENTITY>,
		SERVICE extends BaseService<ENTITY, REPOSITORY>> {
	
	@Autowired
	private SERVICE service;
	
	@PostMapping
	public ResponseEntity<Id> post(@RequestBody ENTITY entity) {
		return ResponseEntity
				.ok()
				.body(new Id(service.save(entity)));
	}
	
	@PutMapping
	public ResponseEntity<Id> updateById(@RequestBody ENTITY entity) {
		return ResponseEntity
				.ok()
				.body(new Id(service.updateById(entity)));
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteById(@RequestBody ENTITY entity) {
		service.deleteById(entity);
		
		return ResponseEntity
				.ok()
				.build();
	}
	
	@GetMapping
	public ResponseEntity<List<ENTITY>> findAll() {
		return ResponseEntity
				.ok()
				.body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ENTITY> findById(@PathVariable UUID id) {
		return ResponseEntity
				.ok()
				.body(service.findById(id));
	}
}
