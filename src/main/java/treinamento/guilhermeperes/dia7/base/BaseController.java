package treinamento.guilhermeperes.dia7.base;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<
		ENTITY extends BaseEntity,
		REPOSITORY extends JpaRepository<ENTITY, UUID>,
		SERVICE extends BaseService<ENTITY, REPOSITORY>> {
	
	@Autowired
	private SERVICE service;
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody ENTITY entity) {
		service.save(entity);
		return ResponseEntity
				.ok()
				.build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updateById(@RequestBody ENTITY entity) {
		service.save(entity);
		return ResponseEntity
				.ok()
				.build();
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
