package treinamento.guilhermeperes.dia7.api.conta;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import treinamento.guilhermeperes.dia7.base.BaseController;
import treinamento.guilhermeperes.dia7.base.annotations.RestConfig;

@RestConfig
@RequestMapping("/api/contas")
public class ContaController extends BaseController<Conta, ContaRepository, ContaService> {
	
	@Autowired
	private ContaService service;
	
	@GetMapping("/hierarquia")
	public ResponseEntity<Map<String, Object>> recuperarHierarquia() {
		return ResponseEntity.ok().body(service.recuperarHierarquia());
	}
}
