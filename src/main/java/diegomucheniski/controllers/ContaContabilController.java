package diegomucheniski.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diegomucheniski.base.BaseController;
import diegomucheniski.domains.ContaContabil;
import diegomucheniski.dto.ContaContabilDTO;
import diegomucheniski.repositories.ContaContabilRepository;
import diegomucheniski.services.ContaContabilService;

@RestController
@RequestMapping("/contascontabeis")
public class ContaContabilController extends BaseController<ContaContabil, ContaContabilDTO, ContaContabilRepository, ContaContabilService> {
	
	@GetMapping("/hierarquia")
	public List<Map<String, Object>> selecionarHierarquia() {
		return service.selecionarHierarquia();
	}
	
	
}
