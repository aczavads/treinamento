package valdenir.junior.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/contascontabeis")
public class ContaContabilsController {
	@Autowired
	private ContaContabilsService service;

	@GetMapping
	public List<ContaContabils> get() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaContabils> get(@PathVariable UUID id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public UUID post(@RequestBody ContaContabilsDTO nova) {
		return service.safe(nova).getId();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		service.delete(id);
	}

	@GetMapping("selecionar-contas-raiz")
	public List<ContaContabils> selecionarContasRaiz() {
		return service.selecionarContasRaiz();
	}

	@GetMapping("contar-contas")
	public Long contarContas() {
		return service.contarContas();
	}

	@GetMapping("recuperar-hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}

	@GetMapping("/paginado")
	public Page<ContaContabils> recuperarTodas(Pageable pageable) {
		return service.recuperarTodas(pageable);
	}

	@GetMapping("/fatiado")
	public Slice<ContaContabils> recuperarTodasFatiadas(Pageable pageable) {
		return service.recuperarTodasFatiadas(pageable);
	}

	@GetMapping("/paginado-manualmente")
	public List<ContaContabils> recuperarTodas(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.recuperarTodasPaginadoManualmente(page, size);
	}
}
