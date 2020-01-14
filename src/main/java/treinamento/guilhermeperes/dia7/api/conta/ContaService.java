package treinamento.guilhermeperes.dia7.api.conta;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.guilhermeperes.dia7.base.BaseService;
import treinamento.guilhermeperes.dia7.base.annotations.TransactionalService;

@TransactionalService
public class ContaService extends BaseService<Conta, ContaRepository> {
	
	@Autowired
	private ContaRepository repo;
	
	public Map<String, Object> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
}
