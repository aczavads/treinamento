package treinamento.thyagofranco.dia7.plano_de_contas.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.thyagofranco.dia7.conta_contabil.entities.ContaContabilThyago;
import treinamento.thyagofranco.dia7.conta_contabil.services.ContaContabilThyagoService;
import treinamento.thyagofranco.dia7.plano_de_contas.DTO.PlanoDeContasTDTO;
import treinamento.thyagofranco.dia7.plano_de_contas.entity.PlanoDeContasT;
import treinamento.thyagofranco.dia7.plano_de_contas.service.PlanoDeContasTService;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasTController {
	
	@Autowired
	private PlanoDeContasTService service;
	
	@Autowired
	private ContaContabilThyagoService serviceContaContabil;
	
	@GetMapping
	private List<PlanoDeContasT> get(){
		return service.findAll();
	}
	
	@GetMapping("/{id}/contas")
	private List<ContaContabilThyago> getContas(@PathVariable("id") UUID id) {
		return serviceContaContabil.findContasDoPlanoDeContas(id);
	}
	
	@PostMapping("/{id}/contas")
	private void postContas(
			@PathVariable("id") UUID idDoPlanoDeContas, 
			@RequestBody List<UUID> idsDasContasParaAdicionar) {
		service.adicionarContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}
	
	@PostMapping
	private UUID post(@RequestBody PlanoDeContasTDTO dto) {
		PlanoDeContasT novo = service.save(dto);
		return novo.getId();
		
	}
	

}
