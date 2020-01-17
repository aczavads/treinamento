package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contascontabeis")
public class MyContaContabilController implements BaseController {

	@Autowired
	private MyContaContabilService contaContabilService;

	@GetMapping
	public List<MyContaContabil> get() {
		return contaContabilService.findAll();
	}

	@GetMapping("/paginado")
	public Page<MyContaContabil> getPaginado(Pageable pageable) {
		return contaContabilService.recuperarTodas(pageable);
	}

	@GetMapping("/paginado-manual")
	public List<MyContaContabil> getPaginadoManual(@RequestParam("page") int page, @RequestParam("size") int size) {
		return contaContabilService.recuperarTodasManual(page, size);
	}

	@GetMapping("/slice")
	public Slice<MyContaContabil> getPaginadoPorSlice(Pageable pageable) {
		return contaContabilService.recuperarTodasFatiado(pageable);
	}

	@PostMapping
	public Long post(@RequestBody MyContaContabilDTO novaContaDTO) {
		return contaContabilService.save(novaContaDTO).getId();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MyContaContabil> getById(@PathVariable Long id) {
		MyContaContabil contaContabil = contaContabilService.findById(id);
		return ResponseEntity.ok(contaContabil);
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
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		contaContabilService.remover(id);
	}
	
	@PutMapping("/{id}")
	public void alterarPlano(@PathVariable Long id, @RequestBody MyContaContabilDTO contaContabilDTO) {
		contaContabilService.alterarDadosPlano(id, contaContabilDTO);
	}
}
