package treinamento.dia10.conta_contabil;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import treinamento.dia10.base.BaseService;
import treinamento.dia10.base.RegistroNaoEncontrado;
import treinamento.dia10.base.TransationalService;

@TransationalService
public class ContaContabilService extends BaseService<
	ContaContabil, 
	ContaContabilDTO, 
	ContaContabilRepository> {

	public List<ContaContabil> findAll() {
		return repo.findAll();
	}
	
	public ContaContabil save(ContaContabilDTO nova) {
		ContaContabil contaSuperior = findContaByIdOrNull(nova.getContaSuperiorId());
		ContaContabil nova = super.save(nova);
	}

	private ContaContabil findContaByIdOrNull(Long id) {
		if (id != null) {
			return  findById(id);
		}
		return null;
	}

	public ContaContabil findById(Long id) {
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

	public List<ContaContabil> findContasDoPlanoDeContas(Long id) {
		return repo.findContasDoPlanoDeContas(id);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void update(ContaContabilDTO dto) {
		ContaContabil contaSuperior = findContaByIdOrNull(dto.getContaSuperiorId());
		
		ContaContabil recuperada = findById(dto.getId());
		recuperada.setCodigo(dto.getCodigo());
		recuperada.setNome(dto.getNome());
		recuperada.setContaSuperior(contaSuperior);
		recuperada.setVersion(dto.getVersion());
	}
}













