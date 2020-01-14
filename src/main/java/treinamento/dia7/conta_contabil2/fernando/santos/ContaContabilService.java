package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@TransationalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabilFS2> findAll() {
		return repo.findAll();
	}
	
	public void save(ContaContabilFS2 nova) {
		repo.save(nova);
	}

	public ContaContabilFS2 findById(UUID id) {
		return repo
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Conta contábil: " + id));
	}
	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
}
