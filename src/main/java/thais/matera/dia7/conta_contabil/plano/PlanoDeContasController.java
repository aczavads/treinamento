package thais.matera.dia7.conta_contabil.plano;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plano-de-contas")
public class PlanoDeContasController {
	@Autowired
	private PlanoDeContasService service;
	
	@GetMapping
	private List<PlanoDeContas> get() {
		return service.findAll();
	}

	@PostMapping
	private UUID post(@RequestBody PlanoDeContasDTO plano) {
		return service.save(plano).getId();
	}
}
