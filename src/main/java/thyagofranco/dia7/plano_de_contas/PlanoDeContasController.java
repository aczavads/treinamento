package thyagofranco.dia7.plano_de_contas;

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

import thyagofranco.dia7.conta_contabil.ContaContabil;
import thyagofranco.dia7.conta_contabil.ContaContabilService;



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
		if(!id.equals(plano.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes");
		}
		service.update(plano);
	}

	@DeleteMapping("/{id}")
	private void delete(@PathVariable("id") UUID id) {
		service.deleteById(id);
	}
	
	@DeleteMapping("/{id}/contas")
	private void deleteContasDoPlano(
			@PathVariable("id") UUID idDoPlanoDeContas, 
			@RequestBody List<UUID> idsDasContasParaRemover) {
		service.deleteContasDoPlano(idDoPlanoDeContas, idsDasContasParaRemover);
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
	
	@PostMapping
	private UUID post(@RequestBody PlanoDeContasDTO dto) {
		PlanoDeContas novo = service.save(dto);
		return novo.getId();
	}
	
	
	
}



