package treinamento.dia10.conta_contabil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import treinamento.dia10.base.BaseController;



@RestController
@RequestMapping("/contascontabeis")
public class ContaContabilController extends BaseController<
		ContaContabil, 
		ContaContabilDTO,
		ContaContabilService> {
	
	@GetMapping("/hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}
	@GetMapping("/paginado-manualmente")
	public List<ContaContabil> recuperarTodas(
			@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.recuperarTodasPaginadoManualmente(page, size);
	}
	
}








