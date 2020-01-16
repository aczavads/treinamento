package diegomucheniski.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diegomucheniski.domains.ContaContabil;
import diegomucheniski.dto.ContaContabilDTO;
import diegomucheniski.services.ContaContabilService;

@RestController
@RequestMapping("/contascontabeis")
public class ContaContabilController {
	
	@Autowired
	private ContaContabilService service;
	
	@GetMapping
	public List<ContaContabil> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ContaContabil findById(@PathVariable UUID id) {
		return service.findById(id);
	}
	
	@GetMapping("/contarContas")
	public Long contarContas() {
		return service.contarContas();
	}
	
	@GetMapping("/selecionarContasRaiz")
	public List<ContaContabil> selecionarContasRaiz() {
		return service.selecionarContasRaiz();
	}
	
	@GetMapping("/selecionarHierarquia")
	List<Map<String, Object>> selecionarHierarquia() {
		return service.selecionarHierarquia();
	}
	
	@PostMapping
	public UUID post(@RequestBody ContaContabilDTO novaContaDTO) {			
		return service.save(novaContaDTO);
	}
	
	@GetMapping("/paginado")
	public Page<ContaContabil> selecionarContasPaginado(Pageable pageable) {
		return service.selecionarContasPaginado(pageable);
	}
	
	@GetMapping("/fatiado")
	public Slice<ContaContabil> selecionarContasFatiado(Pageable pageable) {
		return service.selecionarContasFatiado(pageable);
	}

	@GetMapping("/paginado-manualmente")
	public List<ContaContabil> recuperarTodasContas(
			@RequestParam("page") int page,
			@RequestParam("size") int size
			) {
		return service.recuperarTodasContas(page, size);
	}

}
