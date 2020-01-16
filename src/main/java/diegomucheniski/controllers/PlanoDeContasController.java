package diegomucheniski.controllers;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diegomucheniski.domains.ContaContabil;
import diegomucheniski.domains.PlanoDeContas;
import diegomucheniski.dto.PlanoDeContasDTO;
import diegomucheniski.services.PlanoDeContasService;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController {
	
	@Autowired
	private PlanoDeContasService service;
	
	@GetMapping
	public List<PlanoDeContas> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{planoDeContasId}/contas")
	private Set<ContaContabil> findContasByPlanoId(@PathVariable("id") UUID planoDeContasId) {
		return service.findContasByPlanoId(planoDeContasId);
	}
	
	@PostMapping
	public UUID save(@RequestBody PlanoDeContasDTO planoDeContasDTO) {
		PlanoDeContas planoDeContas = service.save(planoDeContasDTO);
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
	
	@PutMapping("/{planoDeContasId}")
	private void getContas(@PathVariable("planoDeContasId") UUID planoDeContasId, @RequestBody PlanoDeContasDTO planoDeContasDTO) {
		if(!planoDeContasId.equals(planoDeContasDTO.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes");
		}
		service.update(planoDeContasDTO);
	}

}
