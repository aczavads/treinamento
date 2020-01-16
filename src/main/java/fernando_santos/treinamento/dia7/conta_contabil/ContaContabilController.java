package fernando_santos.treinamento.dia7.conta_contabil;

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
@RequestMapping("api/contascontabeis")
public class ContaContabilController {

	@Autowired
	private ContaContabilService service;

	@GetMapping
	public List<ContaContabilFS> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ContaContabilFS getById(@PathVariable UUID id) {
		return service.getById(id);
	}
	
	@GetMapping("/quantidade-de-contas")
	public Long getQuantidadeDeContas() {
		return service.getQuantidadeDeContas();
	}
	
	@GetMapping("/contas-sem-pai")
	public List<ContaContabilFS> getContasSemPai() {
		return service.getContasSemPai();
	}
	
	@GetMapping("/contas-hierarquicamente")
	public List<Map<String, Object>> getContasHierarquicamente() {
		return service.getContasHierarquicamente();
	}

	@PostMapping
	public UUID post(@RequestBody ContaContabilFS contaContabil) {
		service.save(contaContabil);
		return contaContabil.getId();
	}

}
