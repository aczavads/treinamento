package william.dia10.ContaContabil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import william.dia7.Conta_Contabilwd.ContaNãoEncontrada;

@RestController
@RequestMapping("/contasContabeis")
public class ContaContabilController
		extends BaseController<ContaContabil, ContaContabilDTO, ContaContabilRepository, ContaContabilService> {

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
