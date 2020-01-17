package fernando_santos.treinamento.dia10.conta_contabil;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contascontabeis")
public class ContaContabilController {

	@Autowired
	private ContaContabilService service;

	@GetMapping
	public List<ContaContabil> get() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ContaContabil get(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PostMapping
	public Long post(@RequestBody ContaContabilDTO nova) {
		ContaContabil novaContaContabil = service.save(nova);
		return novaContaContabil.getId();
	}
	
	@PutMapping
	public void put(@PathVariable Long id, @RequestBody ContaContabilDTO dto) {
		if(!id.equals(dto.getId())) {
			throw new IllegalArgumentException("Os IDs s�o divergentes");
		}
		service.update(dto);
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}

	@GetMapping("/paginado")
	public Page<ContaContabil> recuperarTodas(Pageable pageable) {
		return service.recuperarTodas(pageable);
	}

	@GetMapping("/fatiado")
	public Slice<ContaContabil> recuperarTodasFatiadas(Pageable pageable) {
		return service.recuperarTodasFatiadas(pageable);
	}

	@GetMapping("/paginado-manualmente")
	public List<ContaContabil> recuperarTodas(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.recuperarTodasPaginadoManualmente(page, size);
	}

}
