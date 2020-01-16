package valdenir.junior.dia7.plano_de_contas;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import valdenir.junior.dia7.conta_contabil.ContaContabils;

@RestController
@RequestMapping("/apis/planosdecontas")
public class PlanoDeContassController {

	@Autowired
	private PlanoDeContassService service;

	@GetMapping
	private List<PlanoDeContass> get() {
		return service.findAll();
	}

	@PostMapping
	private UUID post(@RequestBody PlanoDeContassDTO dto) {
		return service.save(dto).getId();
	}

	@GetMapping("/{id}/contas")
	private List<ContaContabils> buscarContaContabilsPorPlanoDeContas(@PathVariable("id") UUID id) {
		return service.buscarContaContabilsPorPlanoDeContas(id);
	}

	@PostMapping("/{id}/contas")
	private void adicionarContas(@PathVariable("id") UUID idDoPlanoDeContas,
			@RequestBody List<UUID> idsDasContasParaAdicionar) {
		service.adicionarContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}

	@DeleteMapping("/{id}/contas")
	private void deletarContasDoPlanoDeContas(@PathVariable("id") UUID idDoPlanoDeContas,
			@RequestBody List<UUID> idsDasContasParaRemover) {
		service.deletarContasDoPlanoDeContas(idDoPlanoDeContas, idsDasContasParaRemover);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") UUID id) {
		service.remove(id);
	}
}
