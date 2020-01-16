package fernando_santos.treinamento.dia8.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fernando_santos.treinamento.dia8.domain.ContaContabil;
import fernando_santos.treinamento.dia8.dto.ContaContabilDTO;
import fernando_santos.treinamento.dia8.service.ContaContabilService;

@RestController
@RequestMapping("/api/contascontabeis")
public class ContaContabilController {
	@Autowired
	private ContaContabilService service;

	@GetMapping
	public List<ContaContabil> get() {
		return service.findAll();
	}

//	@GetMapping("/{id}")
//	public ContaContabil get(@PathVariable UUID id) {
//		return service.findById(id);
//	}

	@PostMapping
	public UUID post(@RequestBody ContaContabilDTO nova) {
		ContaContabil novaContaContabil = service.save(nova);
		return novaContaContabil.getId();
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}

	@GetMapping("/paginado")
	public Page<ContaContabil> recuperarTodasPaginado(Pageable pageable) {
		return service.recuperarTodasPaginado(pageable);
	}

	@GetMapping("/paginado-com-slice")
	public Page<ContaContabil> recuperarTodasPaginadoComSlice(Pageable pageable) {
		return service.recuperarTodasPaginado(pageable);
	}

	@GetMapping("/paginado-manualmente")
	public List<ContaContabil> recuperarTodasPaginadoManualmente(@RequestParam(value = "page") int page,
			@RequestParam(value = "size") int size) {
		return service.recuperarTodasPaginadoManualmente(page, size);
	}

	@DeleteMapping("/id")
	public void deleteById(@PathVariable("id") UUID idContaContabil) {
		service.deleteById(idContaContabil);
	}
}
