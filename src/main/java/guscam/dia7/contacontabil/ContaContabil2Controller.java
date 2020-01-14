package guscam.dia7.contacontabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contascontabeis")
public class ContaContabil2Controller {
	@Autowired
	private ContaContabil2Service service;
	
	@GetMapping
	public List<ContaContabil2> get() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ContaContabil2 findById(@PathVariable UUID id) {
		return service.findById(id);
	}

	@GetMapping("/total-contas")
	public Long contarNumeroDeContas() {
		return service.contarNumeroDeContas();
	}

	@GetMapping("/raizes")
	public List<ContaContabil2> selecionarContasRaiz() {
		return service.selecionarContasRaiz();
	}

	@GetMapping("/pela-hierarquia")
	public List<Map<String, Object>> listar() {
		return service.selecionarContasPelaHierarquia();
	}
	
	@PostMapping
	public UUID post(@RequestBody ContaContabil2 nova) {
		service.save(nova);
		return nova.getId();
	}

}
