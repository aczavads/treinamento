package fernando_santos.treinamento.dia10.plano_de_contas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fernando_santos.treinamento.dia10.conta_contabil.ContaContabil;
import fernando_santos.treinamento.dia10.conta_contabil.ContaContabilService;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController {
	@Autowired
	private PlanoDeContasService service;

	@Autowired
	private ContaContabilService serviceContaContabil;

	@GetMapping
	private List<PlanoDeContas> get() {
		return service.findAll();
	}

	@PutMapping("/{id}")
	private void getContas(@PathVariable("id") Long id, @RequestBody PlanoDeContasDTO plano) {
		if (!id.equals(plano.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes!");
		}
		service.update(plano);
	}

	@DeleteMapping("/{id}/contas")
	private void deleteContasDoPlano(@PathVariable("id") Long id, @RequestBody List<Long> idsDasContasParaRemover) {
		service.deleteContasDoPlano(id, idsDasContasParaRemover);
	}

	@DeleteMapping("/{id}")
	private void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	@GetMapping("/{id}/contas")
	private List<ContaContabil> getContas(@PathVariable("id") Long id) {
		return serviceContaContabil.findContasDoPlanoDeContas(id);
		// return service.getContas(id);
	}

	@PostMapping("/{id}/contas")
	private void postContas(@PathVariable("id") Long idDoPlanoDeContas,
			@RequestBody List<Long> idsDasContasParaAdicionar) {
		service.adicionarContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}

//	@DeleteMapping("/{id}/contas")
//	private void removerContas(
//			@PathVariable("id") Long idDoPlanoDeContas, 
//			@RequestBody List<Long> idsDasContasParaRemover) {
//		service.removerContas(idDoPlanoDeContas, idsDasContasParaRemover);
//	}

	@PostMapping
	private Long post(@RequestBody PlanoDeContasDTO dto) {
		PlanoDeContas novo = service.save(dto);
		return novo.getId();
	}

}
