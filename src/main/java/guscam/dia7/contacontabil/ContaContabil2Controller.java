package guscam.dia7.contacontabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/paginado")
	public Page<ContaContabil2> recuperarTodas(Pageable pageable) {
		return service.recuperarTodas(pageable);
	}

	@GetMapping("/paginado-manualmente")
	public List<ContaContabil2> recuperarTodasManualmente(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.recuperarTodasManualmente(page, size);
	}

	@GetMapping("/fatiado")
	public Slice<ContaContabil2> recuperarTodasFatiadas(Pageable pageable) {
		return service.recuperarTodasFatiadas(pageable);
	}
	
	@PostMapping
	public UUID post(@RequestBody ContaContabil2DTO nova) {
		ContaContabil2 novaConta = service.save(nova);
		return novaConta.getId();
	}
}
