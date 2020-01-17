package diegomucheniski.services;

import java.util.List;
import java.util.Map;

import diegomucheniski.annotations.TransactionalService;
import diegomucheniski.base.BaseService;
import diegomucheniski.domains.ContaContabil;
import diegomucheniski.dto.ContaContabilDTO;
import diegomucheniski.repositories.ContaContabilRepository;


@TransactionalService
public class ContaContabilService extends BaseService<ContaContabil, ContaContabilDTO, ContaContabilRepository> {
	
	public List<Map<String, Object>> selecionarHierarquia() {
		return repository.selecionarHierarquia();
	}

}
