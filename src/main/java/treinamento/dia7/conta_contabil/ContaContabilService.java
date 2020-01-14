package treinamento.dia7.conta_contabil;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@TransationalService
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
		return repo
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Conta contábil: " + id));
	}
}
