package thais.matera.dia7.plano_de_conta;

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

import thais.matera.dia7.conta_contabil.ContaContabil;

@RestController
@RequestMapping("/planodecontas")
public class PlanoDeContasController {
	@Autowired
	private PlanoDeContasService service;
	
	@GetMapping
	private List<PlanoDeContas> get() {
		return service.findAll();
	}

	@GetMapping("/{id}/contas")
	private List<ContaContabil> getContas(@PathVariable("id") UUID id) {
		return service.findContasDoPlanoDeContas(id);
	}
	
	@PostMapping("/{id}/contas")
	private void postContas(@PathVariable("id") UUID id, @RequestBody List<UUID> contasID) {
		service.adicionarContas(id, contasID);
	}
	
	@DeleteMapping("/{id}/contas")
	private void deleteConta(@PathVariable("id") UUID id, @RequestBody List<UUID> contasID) {
		service.removerContas(id, contasID);
	}
	
	@PostMapping
	private UUID post(@RequestBody PlanoDeContasDTO plano) {
		return service.save(plano).getId();
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable("id") UUID id) {
		service.delete(id);
	}
}
