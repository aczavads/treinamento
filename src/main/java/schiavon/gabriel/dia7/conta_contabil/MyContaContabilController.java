package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import schiavon.gabriel.dia7.base.BaseController;

@RestController
@RequestMapping("/contascontabeis")
public class MyContaContabilController extends BaseController<Long, MyContaContabil, MyContaContabilDTO, MyContaContabilRepository, MyContaContabilService> {

	@GetMapping("/contas_raiz")
	public List<MyContaContabil> getContasRaiz() {
		return service.getContasRaiz();
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> getContasRaizPorHierarquia() {
		return service.getContasRaizPorHierarquia();
	}
}
