package treinamento.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@TransationalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabil> findAll() {
		return repo.findAll();
	}
	
	public ContaContabil save(ContaContabilDTO nova) {
		ContaContabil contaSuperior = null;
		if (nova.getContaSuperiorId() != null) {
			contaSuperior = findById(nova.getContaSuperiorId());
		}
		ContaContabil novaContaContabil = null;
		if (nova.getId() == null) {
			novaContaContabil = new ContaContabil(nova.getCodigo(), nova.getNome(), contaSuperior);			
		} else {
			novaContaContabil = new ContaContabil(nova.getId(), nova.getCodigo(), nova.getNome(), contaSuperior);			
		}
		return repo.save(novaContaContabil);
	}

	public ContaContabil findById(UUID id) {
		return repo
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Conta contábil: " + id));
	}
	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
	public Page<ContaContabil> recuperarTodas(Pageable pageable) {
		return repo.recuperarTodas(pageable);
	}
	public Slice<ContaContabil> recuperarTodasFatiadas(Pageable pageable) {
		return repo.recuperarTodasFatiadas(pageable);
	}

	public List<ContaContabil> recuperarTodasPaginadoManualmente(int page, int size) {
		return repo.recuperarTodasPaginadoManualmente(page, size);
	}

	public List<ContaContabil> findContasDoPlanoDeContas(UUID id) {
		return repo.findById(id).get().getContasFilhas();
		//return repo.findContasDoPlanoDeContas(id);
	}
}













