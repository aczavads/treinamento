package thais.matera.dia7.conta_contabil;

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
public class ContaContabilController {
	@Autowired
	private ContaContabilService service;
	
	@GetMapping
	public List<ContaContabil> get() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ContaContabil get(@PathVariable UUID id) {
		return service.findById(id);
	}
	
	@GetMapping("/contarContas")
	public Long getCount() {
		return service.contarContas();
	}
	
	@GetMapping("/selecionarContasRaiz")
	public List<ContaContabil> selecionarContasRaiz() {
		return service.selecionarContasRaiz();
	}
	
	@GetMapping("/recuperarHierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}
	
	@PostMapping
	public UUID post(@RequestBody ContaContabil nova) {
		service.save(nova);
		return nova.getId();
	}
	
}
