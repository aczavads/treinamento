package fernando_santos.treinamento.dia10.conta_contabil;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fernando_santos.treinamento.dia10.base.BaseController;

@RestController
@RequestMapping("/contascontabeis")
public class ContaContabilController extends BaseController<
	ContaContabil, 
	ContaContabilDTO, 
	ContaContabilRepository,
	ContaContabilService> {

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}

}
