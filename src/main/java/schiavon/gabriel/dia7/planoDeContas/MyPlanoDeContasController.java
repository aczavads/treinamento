package schiavon.gabriel.dia7.planoDeContas;

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

import schiavon.gabriel.dia7.conta_contabil.MyContaContabil;

@RestController
@RequestMapping("/api/planosdecontas")
public class MyPlanoDeContasController {

	@Autowired
	private MyPlanoDeContasService service;
	
	@PostMapping
	public UUID post(@RequestBody MyPlanoDeContasDTO myPlanoDeContasDTO) {
		return service.save(myPlanoDeContasDTO).getId();
	}
	
	@PostMapping("/{id}/contas")
	public void postAdicionarContas(@PathVariable UUID id, @RequestBody List<UUID> idsContasParaAdicionar) {
		service.adicionarContas(id, idsContasParaAdicionar);
	}
	
	@GetMapping("/{id}/contas")
	public Set<MyContaContabil> getContas(@PathVariable UUID id) {
		return service.getAllContasPlano(id);
	}
	
	@GetMapping
	public List<MyPlanoDeContas> getAll() {
		return service.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteConta(@PathVariable UUID id) {
		service.deletarPlano(id);
	}
	
	@DeleteMapping("/{id}/contas")
	public void deleteConta(@PathVariable UUID id, @RequestBody List<UUID> idsContasParaRemover) {
		service.deletarContasDoPlano(id, idsContasParaRemover);
	}
}
