package diegomucheniski.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diegomucheniski.base.BaseController;
import diegomucheniski.domains.ContaContabil;
import diegomucheniski.domains.PlanoDeContas;
import diegomucheniski.dto.PlanoDeContasDTO;
import diegomucheniski.repositories.PlanoDeContasRepository;
import diegomucheniski.services.PlanoDeContasService;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController extends BaseController<PlanoDeContas, PlanoDeContasDTO, PlanoDeContasRepository, PlanoDeContasService> {
			
	@GetMapping("/{planoDeContasId}/contas")
	private Set<ContaContabil> findContasByPlanoId(@PathVariable("id") Long planoDeContasId) {
		return service.findContasByPlanoId(planoDeContasId);
	}	
	
	@PostMapping("/{planoDeContasId}/contas")
	public void adicionarContas(@PathVariable("planoDeContasId") Long planoDeContasId, @RequestBody List<Long> idsDasContasParaAdicionar ) {
		service.adicionarContas(planoDeContasId, idsDasContasParaAdicionar);
	}
	
	@DeleteMapping("/{planoDeContasId}/contas")
	public void removerContas(@PathVariable("planoDeContasId") Long planoDeContasId, @RequestBody List<Long> idsDasContasParaAdicionar ) {
		service.removerContas(planoDeContasId, idsDasContasParaAdicionar);
	}
	
}
