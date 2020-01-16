package treinamento.thyagofranco.dia7.conta_contabil.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.aspectj.bridge.context.PinpointingMessageHandler;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import treinamento.thyagofranco.dia7.conta_contabil.DTOs.ContaContabilThyagoDTO;
import treinamento.thyagofranco.dia7.conta_contabil.entities.ContaContabilThyago;
import treinamento.thyagofranco.dia7.conta_contabil.services.ContaContabilThyagoService;

@RestController
@RequestMapping("/contascontabeis") // uri a qual responde
public class ContaContabilThyagoController implements BaseController{
	@Autowired
	private ContaContabilThyagoService service;

	@GetMapping
	public List<ContaContabilThyago> get() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<ContaContabilThyago> get(@PathVariable UUID id) {
		return service.findById(id);

	}
	
//	@PostMapping
//	public UUID post(@RequestBody ContaContabilThyago nova) {
//		service.save(nova);
//		return nova.getId();
//	}

	@PostMapping
	public UUID post(@RequestBody ContaContabilThyagoDTO nova) {
		ContaContabilThyago novaContabilThyago = service.save(nova);
		return novaContabilThyago.getId();
	}

	@GetMapping("/total-contas")
	public Long getTotalContas() {
		return service.contarContas();
	}

	@GetMapping("/conta-raiz")
	public List<ContaContabilThyago> selecionarContasRaiz() {
		return service.selecionarContasRaiz();
	}

	@GetMapping("/hierarquia")
	public List<Map<String, Object>> recuperarHierarquia() {
		return service.recuperarHierarquia();
	}
	
	@GetMapping("/paginado")
	public Page<ContaContabilThyago> recuperarTodas(Pageable pageable){
		return service.recuperarTodas(pageable);
		
	}
	
	@GetMapping("/fatiado")
	public Slice<ContaContabilThyago> recuperarTodasFatiadas(Pageable pageable){
		return service.recuperarTodasFatiadas(pageable);
	}
	
	@GetMapping("/paginado-manualmente")
	public List<ContaContabilThyago> recuperarTodas(
			@RequestParam("page") int page, @RequestParam("size") int size){
		return service.recuperarTodasPaginadoManualmente(page, size);
		
	}
	
	
	

}
