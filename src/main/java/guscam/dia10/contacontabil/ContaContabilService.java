package guscam.dia10.contacontabil;

import java.util.List;
import java.util.Map;

import guscam.dia10.base.BaseService;
import guscam.dia10.base.TransationalService;

@TransationalService
public class ContaContabilService extends BaseService<ContaContabil, ContaContabilDTO, ContaContabilRepository> {

	@Override
	public ContaContabil save(ContaContabilDTO dto) {
		ContaContabil novaContaContabil = dto.toEntity();
		novaContaContabil.setContaSuperior(findByIdOrNull(novaContaContabil.getContaSuperiorId()));
		return repository.save(novaContaContabil);
	}

	@Override
	public void update(ContaContabilDTO dto) {
		ContaContabil actual = findById(dto.getId());
		System.out.println(actual.getVersion());
		ContaContabil entity = dto.mergeEntity(actual);
		System.out.println(entity.getVersion());
		entity.setContaSuperior(findByIdOrNull(actual.getContaSuperiorId()));
	}

	public List<Map<String, Object>> recuperarHierarquia() {
		return repository.recuperarHierarquia();
	}

	public List<ContaContabil> findContasDoPlanoDeContas(Long id) {
		return repository.findContasDoPlanoDeContas(id);
	}
}













