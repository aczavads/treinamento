package thais.matera.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@TransactionalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;
	
	public List<ContaContabil> findAll() {
		return repo.findAll();
	}

	public void save(ContaContabil nova) {
		repo.save(nova);
	}

	public ContaContabil findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contabil " + id));
	}
	
	public Long contarContas() {
		return repo.contarContas();
	}
	
	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
	
	public List<ContaContabil> selecionarContasRaiz() {
		return repo.selecionarContasRaiz();
	}
}
