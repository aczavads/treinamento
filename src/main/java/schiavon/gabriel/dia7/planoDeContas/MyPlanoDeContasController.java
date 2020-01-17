package schiavon.gabriel.dia7.planoDeContas;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import schiavon.gabriel.dia7.base.BaseController;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabil;

@RestController
@RequestMapping("/planosdecontas")
public class MyPlanoDeContasController extends
		BaseController<Long, MyPlanoDeContas, MyPlanoDeContasDTO, MyPlanoDeContasRepository, MyPlanoDeContasService> {

	@PostMapping("/{id}/contas")
	public void postAdicionarContas(@PathVariable Long id, @RequestBody List<Long> idsContasParaAdicionar) {
		service.adicionarContas(id, idsContasParaAdicionar);
	}

	@GetMapping("/{id}/contas")
	public Set<MyContaContabil> getContas(@PathVariable Long id) {
		return service.getAllContasPlano(id);
	}

	@DeleteMapping("/{id}/contas")
	public void deleteConta(@PathVariable Long id, @RequestBody List<Long> idsContasParaRemover) {
		service.deletarContasDoPlano(id, idsContasParaRemover);
	}

}
