package william.dia8;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController {
	@Autowired
	private PlanoDeContasService service;

	@GetMapping
	private List<PlanoDeContas> get() {
		System.out.println("teste");
		return service.findAll();
	}

	@PostMapping
	private PlanoDeContas save(@RequestBody PlanoDeContasDTO dto) {

		return service.save(dto);
	}

	@PostMapping("/{id}/addContas")
	private List<ContaContabil> addContas(@PathVariable("id") UUID idDoPlanoDeContas,
			@RequestBody List<UUID> idsDasContasParaAdicionar) {
		return service.addContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}

	@PostMapping("/{id}")
	private List<ContaContabil> removeContas(@PathVariable("id") UUID idDoPlanoDeContas,
			@RequestBody List<UUID> idsDasContasParaRemover) {
		return service.removeContas(idDoPlanoDeContas, idsDasContasParaRemover);
	}

	@DeleteMapping("/{id}")
	private void remove(@PathVariable("id") UUID idDoPlanoDeContas) {
		service.remove(idDoPlanoDeContas);
	}

	@GetMapping("/{id}/contas")
	private Set<ContaContabil> getContas(@PathVariable("id") UUID idDoPlanoDeContas) {
		return service.getContas(idDoPlanoDeContas);
	}
}
