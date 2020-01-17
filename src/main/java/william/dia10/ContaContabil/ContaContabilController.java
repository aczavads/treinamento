package william.dia10.ContaContabil;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contasContabeis")
public class ContaContabilController
		extends BaseController<
		ContaContabil, 
		ContaContabilDTO,
		ContaContabilRepository,
		ContaContabilService> {

	@GetMapping("/contadorContas")
	public Long contadorContas() {
		return service.contarContas();
	}

	@GetMapping("/contasRaiz")
	public List<ContaContabil> contasRaiz() {
		return service.contasRaiz();
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> hierarquia() {
		return service.hierarquia();
	}

}
