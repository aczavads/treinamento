package william.dia10.PlanoDeContas;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import william.dia10.ContaContabil.BaseController;
import william.dia10.ContaContabil.ContaContabil;
import william.dia10.ContaContabil.ContaContabilService;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController
		extends BaseController<PlanoDeContas, PlanoDeContasDTO, PlanoDeContasRepository, PlanoDeContasService> {
	
	@Autowired
	private ContaContabilService contaContabilService;

//	@GetMapping
//	private List<PlanoDeContas> get() {
//		System.out.println("teste");
//		return service.findAll();
//	}

	@PostMapping("/{id}/contas")
	private List<ContaContabil> addContas(@PathVariable("id") Long idDoPlanoDeContas,
			@RequestBody List<Long> idsDasContasParaAdicionar) {
		return service.addContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}

	@DeleteMapping("/{id}/contas")
	private List<ContaContabil> removeContas(@PathVariable("id") Long idDoPlanoDeContas,
			@RequestBody List<Long> idsDasContasParaRemover) {
		return service.removeContas(idDoPlanoDeContas, idsDasContasParaRemover);
	}

	@GetMapping("/{id}/contas")
	private Set<ContaContabil> getContas(@PathVariable("id") Long idDoPlanoDeContas) {
		return service.getContas(idDoPlanoDeContas);
	}
}
