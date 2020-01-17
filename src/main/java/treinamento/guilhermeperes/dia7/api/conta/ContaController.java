package treinamento.guilhermeperes.dia7.api.conta;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import treinamento.guilhermeperes.dia7.base.BaseController;
import treinamento.guilhermeperes.dia7.base.annotations.RestConfig;

@RestConfig
@RequestMapping("/contas")
public class ContaController extends BaseController<Conta, ContaRepository, ContaService> {
	
	@GetMapping("/hierarquia")
	public ResponseEntity<List<Map<String, Object>>> recuperarHierarquia() {
		return ResponseEntity
				.ok()
				.body(service.recuperarHierarquia());
	}
	
	@GetMapping("/page")
	public ResponseEntity<Slice<Conta>> findAllSlice(Pageable pageable) {
		return ResponseEntity
				.ok()
				.body(service.findAllSlice(pageable));
	}
}
