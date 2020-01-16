package treinamento.dia7.plano_de_contas;

import java.util.List;
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

import treinamento.dia7.conta_contabil.ContaContabil;
import treinamento.dia7.conta_contabil.ContaContabilService;

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
	private void getContas(@PathVariable("id") UUID id, @RequestBody PlanoDeContasDTO plano) {
		service.save(plano);
	}

	@DeleteMapping("/{id}")
	private void delete(@PathVariable("id") UUID id) {
		service.deleteById(id);
	}
	
	@GetMapping("/{id}/contas")
	private List<ContaContabil> getContas(@PathVariable("id") UUID id) {
		return serviceContaContabil.findContasDoPlanoDeContas(id);
		//return service.getContas(id);
	}

	@PostMapping("/{id}/contas")
	private void postContas(
			@PathVariable("id") UUID idDoPlanoDeContas, 
			@RequestBody List<UUID> idsDasContasParaAdicionar) {
		service.adicionarContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}
	
//	@DeleteMapping("/{id}/contas")
//	private void removerContas(
//			@PathVariable("id") UUID idDoPlanoDeContas, 
//			@RequestBody List<UUID> idsDasContasParaRemover) {
//		service.removerContas(idDoPlanoDeContas, idsDasContasParaRemover);
//	}
	
	@PostMapping
	private UUID post(@RequestBody PlanoDeContasDTO dto) {
		PlanoDeContas novo = service.save(dto);
		return novo.getId();
	}
	
}



