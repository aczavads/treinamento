package treinamento.diegomucheniski.dia7.plano_de_contas;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.diegomucheniski.dia7.conta_contabil.ContaContabilMucheniski;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasMucheniskiController {
	
	@Autowired
	private PlanoDeContasMucheniskiService service;
	
	@GetMapping
	public List<PlanoDeContasMucheniski> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{planoDeContasId}/contas")
	private Set<ContaContabilMucheniski> findContasByPlanoId(@PathVariable("id") UUID planoDeContasId) {
		return service.findContasByPlanoId(planoDeContasId);
	}
	
	@PostMapping
	public UUID save(@RequestBody PlanoDeContasMucheniskiDTO planoDeContasDTO) {
		PlanoDeContasMucheniski planoDeContas = service.save(planoDeContasDTO);
		return planoDeContas.getId();
	}
	
	@PostMapping("/{planoDeContasId}/contas")
	public void adicionarContas(@PathVariable("planoDeContasId") UUID planoDeContasId, @RequestBody List<UUID> idsDasContasParaAdicionar ) {
		service.adicionarContas(planoDeContasId, idsDasContasParaAdicionar);
	}
	
	@DeleteMapping("/{planoDeContasId}/contas")
	public void removerContas(@PathVariable("planoDeContasId") UUID planoDeContasId, @RequestBody List<UUID> idsDasContasParaAdicionar ) {
		service.removerConta(planoDeContasId, idsDasContasParaAdicionar);
	}
	
	@DeleteMapping("/{planoDeContasId}")
	public void deleteById(@PathVariable("planoDeContasId") UUID planoDeContasId) {
		service.deleteById(planoDeContasId);
	}

}
