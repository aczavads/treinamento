package treinamento.diegomucheniski.dia7.conta_contabil;

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
public class ContaContabilMucheniskiController {
	
	@Autowired
	private ContaContabilMucheniskiService service;
	
	@GetMapping
	public List<ContaContabilMucheniski> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ContaContabilMucheniski findById(@PathVariable UUID id) {
		return service.findById(id).get();
	}
	
	@GetMapping("/contarContas")
	public Long contarContas() {
		return service.contarContas();
	}
	
	@GetMapping("/selecionarContasRaiz")
	public List<ContaContabilMucheniski> selecionarContasRaiz() {
		return service.selecionarContasRaiz();
	}
	
	@GetMapping("/selecionarHierarquia")
	List<Map<String, Object>> selecionarHierarquia() {
		return service.selecionarHierarquia();
	}
	
	@PostMapping
	public UUID post(@RequestBody ContaContabilMucheniskiDTO novaContaDTO) {		
		ContaContabilMucheniski novaConta = service.save(novaContaDTO);
		return novaConta.getId();
	}

}
