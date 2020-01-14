package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contascontabeis")
public class MyContaContabilController implements BaseController {

	@Autowired
	private MyContaContabilService contaContabilService;

	@GetMapping
	public List<MyContaContabil> get() {
		return contaContabilService.findAll();
	}

	@PostMapping
	public UUID post(@RequestBody MyContaContabilDTO novaContaDTO) {
		return contaContabilService.save(novaContaDTO).getId();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MyContaContabil> getById(@PathVariable UUID id) {
		Optional<MyContaContabil> optinal = contaContabilService.findById(id);
		if (optinal.isPresent()) {
			return ResponseEntity.ok(optinal.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/quantidade")
	public Long getQuantidadeContas() {
		return contaContabilService.getQuantidadeContas();
	}

	@GetMapping("/contas_raiz")
	public List<MyContaContabil> getContasRaiz() {
		return contaContabilService.getContasRaiz();
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> getContasRaizPorHierarquia() {
		return contaContabilService.getContasRaizPorHierarquia();
	}
}
