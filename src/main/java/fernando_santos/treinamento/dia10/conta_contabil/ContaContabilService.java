package fernando_santos.treinamento.dia10.conta_contabil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import fernando_santos.treinamento.dia10.base.RegistroNaoEncontrado;
import fernando_santos.treinamento.dia10.base.TransationalService;

@TransationalService
public class ContaContabilService {

	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabil> findAll() {
		return repo.findAll();
	}

	public ContaContabil save(ContaContabilDTO nova) {
		ContaContabil contaSuperior = findContaSuperiorById(nova.getId());
		ContaContabil novaContaContabil = ContaContabil.builder().id(nova.getId()).version(nova.getVersion())
				.nome(nova.getNome()).codigo(nova.getCodigo()).contaSuperior(contaSuperior).build();
		return repo.save(novaContaContabil);
	}

	private ContaContabil findContaSuperiorById(Long id) {
		ContaContabil contaSuperior = null;
		if (id != null) {
			contaSuperior = findById(id);
		}
		return contaSuperior;
	}

	public ContaContabil findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contábil: " + id));
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

	public List<ContaContabil> findContasDoPlanoDeContas(Long id) {
		return repo.findContasDoPlanoDeContas(id);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void update(ContaContabilDTO dto) {
		ContaContabil contaContabilRecuperada = findById(dto.getId());
		ContaContabil contaSuperiorRecuperada = findContaSuperiorById(dto.getContaSuperiorId());
		contaContabilRecuperada.setCodigo(dto.getCodigo());
		contaContabilRecuperada.setNome(dto.getNome());
		contaContabilRecuperada.setContaSuperior(contaSuperiorRecuperada);
		contaContabilRecuperada.setVersion(dto.getVersion());
	}
}
