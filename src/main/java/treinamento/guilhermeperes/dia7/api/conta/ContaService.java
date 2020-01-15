package treinamento.guilhermeperes.dia7.api.conta;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Slice;

import treinamento.guilhermeperes.dia7.base.BaseService;
import treinamento.guilhermeperes.dia7.base.annotations.TransactionalService;

@TransactionalService
public class ContaService extends BaseService<Conta, ContaRepository> {
	
	@Autowired
	private ContaRepository repo;
	
	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
	
	public Slice<Conta> findAllSlice(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
