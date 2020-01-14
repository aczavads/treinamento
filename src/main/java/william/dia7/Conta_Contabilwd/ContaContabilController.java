package william.dia7.Conta_Contabilwd;

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
@RequestMapping("/api/contasContabeis")
public class ContaContabilController {
	@Autowired
	private ContaContabilService service;
	
	@GetMapping
	public List<ContaContabil> get(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ContaContabil get(@PathVariable UUID id) {
		return service.findById(id);
	}
	
	@GetMapping("/contadorContas")
	public Long contadorContas() {
		return service.contarContas();
	}
	
	@GetMapping("/contasRaiz")
	public List<ContaContabil> contasRaiz() {
		return service.contasRaiz();
	}
	
	@GetMapping("/hierarquia")
	public List<Map<String, Object>> hierarquia() {
		return service.hierarquia();
	}
	
	@PostMapping
	public UUID post(@RequestBody ContaContabil nova) {
		service.save(nova);
		return nova.getId();
	}
}
