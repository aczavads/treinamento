package fernando_santos.treinamento.dia8.controller;

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

import fernando_santos.treinamento.dia8.domain.ContaContabil;
import fernando_santos.treinamento.dia8.domain.PlanoDeContas;
import fernando_santos.treinamento.dia8.dto.PlanoDeContasDTO;
import fernando_santos.treinamento.dia8.service.ContaContabilService;
import fernando_santos.treinamento.dia8.service.PlanoDeContasService;

@RestController
@RequestMapping("/api/plano-de-contas")
public class PlanoDeContasController {

	@Autowired
	private PlanoDeContasService planoDeContasService;

	private ContaContabilService contaContabilService;

	@GetMapping
	private List<PlanoDeContas> get() {
		return planoDeContasService.findAll();
	}

	@GetMapping("/{id}/contas")
	private List<ContaContabil> getContas(@PathVariable("id") UUID id) {
		return contaContabilService.findContasDoPlanoDeContas(id);
	}

	@PostMapping("/{id}/contas")
	private void postContas(@PathVariable("id") UUID idDoPlanoDeContas,
			@RequestBody List<UUID> idsDasContasParaAdicionar) {
		planoDeContasService.adicionarContas(idDoPlanoDeContas, idsDasContasParaAdicionar);
	}

	@PostMapping
	private UUID post(@RequestBody PlanoDeContasDTO dto) {
		PlanoDeContas novo = planoDeContasService.save(dto);
		return novo.getId();
	}

	@DeleteMapping("/{id}")
	private void removeById(@PathVariable("id") UUID idPlanoDeContas) {
		planoDeContasService.removeById(idPlanoDeContas);
	}

	@DeleteMapping("/{id}/contas")
	private void removeContasDoPlanoDeContas(@PathVariable("id") UUID idPlanoDeContas,
			@RequestBody Set<UUID> idsContasContabeis) {
		planoDeContasService.removeContasDoPlanoDeContas(idPlanoDeContas, idsContasContabeis);
	}

	@PutMapping("/{id}")
	private void atualizaContas(@PathVariable UUID idPlanoDeContas, @RequestBody PlanoDeContasDTO planoDeContas) {
		if (!idPlanoDeContas.equals(planoDeContas.getId())) {
			throw new IllegalArgumentException("Os IDs são divergentes");
		}
		planoDeContasService.update(planoDeContas);
	}

}
