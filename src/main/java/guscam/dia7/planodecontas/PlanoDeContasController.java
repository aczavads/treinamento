package guscam.dia7.planodecontas;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guscam.dia7.contacontabil.ContaContabil;
import guscam.dia7.contacontabil.ContaContabilService;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController {
	@Autowired
	private PlanoDeContasService service;

	@Autowired
	private ContaContabilService serviceContaContabil;

	@GetMapping
	private List<PlanoDeContas> get(){
		return service.findAll();
	}
	@GetMapping("/{id}/contas")
	private List<ContaContabil> getContas(@PathVariable("id") UUID idDoPlano){
		return serviceContaContabil.recuperarContasDoPlanoDeContas(idDoPlano);
	}
	
	@PostMapping
	private UUID post(@RequestBody PlanoDeContasDTO dto) {
		PlanoDeContas novo = service.save(dto);
		return novo.getId();
	}

	@PostMapping("/{id}/contas")
	private void postContas(@PathVariable("id") UUID idDoPlano, @RequestBody List<UUID> idsDasContas) {
		service.adicionarContas(idDoPlano, idsDasContas);
	}

	@DeleteMapping("/{id}/contas")
	private void removerContas(@PathVariable("id") UUID idDoPlano, @RequestBody List<UUID> idsDasContas) {
		service.removerContas(idDoPlano, idsDasContas);
	}

	@DeleteMapping("/{id}")
	private void remover(@PathVariable("id") UUID idDoPlano) {
		service.remover(idDoPlano);
	}
}
