package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plano-de-contas")
public class PlanoDeContasController {
	
	@Autowired
	private PlanoDeContasService service;
	
	private List<PlanoDeContasFS2> getAll() {
		return service.getAll();
	}

}
