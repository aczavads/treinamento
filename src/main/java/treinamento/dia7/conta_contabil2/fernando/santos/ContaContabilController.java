package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contascontabeis")
public class ContaContabilController {
	@Autowired
	private ContaContabilService service;

	@GetMapping
	public List<ContaContabilFS2> get() {
		return service.findAll();
	}

//	@GetMapping("/{id}")
//	public ContaContabilFS2 get(@PathVariable UUID id) {
//		return service.findById(id);
//	}

	@PostMapping
	public UUID post(@RequestBody ContaContabilDTO nova) {
		ContaContabilFS2 novaContaContabil = service.save(nova);
		return novaContaContabil.getId();
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}

	@GetMapping("/paginado")
	public Page<ContaContabilFS2> recuperarTodasPaginado(Pageable pageable) {
		return service.recuperarTodasPaginado(pageable);
	}

	@GetMapping("/paginado-com-slice")
	public Page<ContaContabilFS2> recuperarTodasPaginadoComSlice(Pageable pageable) {
		return service.recuperarTodasPaginado(pageable);
	}

	@GetMapping("/paginado-manualmente")
	public List<ContaContabilFS2> recuperarTodasPaginadoManualmente(@RequestParam(value = "page") int page,
			@RequestParam(value = "size") int size) {
		return service.recuperarTodasPaginadoManualmente(page, size);
	}
}
