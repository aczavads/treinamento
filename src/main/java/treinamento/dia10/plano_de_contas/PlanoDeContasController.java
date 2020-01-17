package treinamento.dia10.plano_de_contas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.dia10.base.BaseController;
import treinamento.dia10.conta_contabil.ContaContabil;
import treinamento.dia10.conta_contabil.ContaContabilService;



@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController extends BaseController<
		PlanoDeContas, 
		PlanoDeContasDTO, 
		PlanoDeContasService>{

	@Autowired
	private ContaContabilService serviceContaContabil;
		
	@DeleteMapping("/{id}/contas")
	private void deleteContas (
			@PathVariable("id") Long id, 
			@RequestBody List<Long> idsDasContasParaRemover) {
		service.deleteContasDoPlano(id, idsDasContasParaRemover);
	}
	
	@GetMapping("/{id}/contas")
	private List<ContaContabil> getContas(@PathVariable("id") Long id) {
		return serviceContaContabil.findContasDoPlanoDeContas(id);
	}

	@PostMapping("/{id}/contas")
	private void postContas(
			@PathVariable("id") Long idDoPlanoDeContas, 
			@RequestBody List<Long> idsDasContasParaAdicionar) {
		service.adicionarContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}
}



