package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;

import schiavon.gabriel.dia7.TransationalService;
import schiavon.gabriel.dia7.base.BaseService;

@TransationalService
public class MyContaContabilService extends BaseService<Long, MyContaContabil, MyContaContabilDTO, MyContaContabilRepository> {

//	@Override
//	public MyContaContabil save(MyContaContabilDTO dto) {
//		return repository.save(dto.toEntity());
//	}
//	
//	@Override
//	public void update(Long id, MyContaContabilDTO dto) {
//		MyContaContabil atual = findById(id);
//		MyContaContabil mergedToSave = dto.mergeEntity(atual);
//		mergedToSave.setContaSuperior(findContaSuperiorOrNull(dto.getContaSuperiorId()));
//	}

	public List<MyContaContabil> getContasRaiz() {
		return repository.selecionarContasRaiz();
	}

	public List<Map<String, Object>> getContasRaizPorHierarquia() {
		return repository.selecionarContasPorHierarquia();
	}

	public void alterarDadosPlano(Long id, MyContaContabilDTO contaContabilDTO) {
		MyContaContabil contaContabil = findById(id);
		MyContaContabil contaSuperior = findContaSuperiorOrNull(contaContabilDTO.getId());
		contaContabil.setCodigo(contaContabilDTO.getCodigo());
		contaContabil.setNome(contaContabilDTO.getNome());
		contaContabil.setContaSuperior(contaSuperior);
	}

	private MyContaContabil findContaSuperiorOrNull(Long idContaSuperior) {
		if (idContaSuperior != null) {
			return findById(idContaSuperior);
		}
		
		return null;
	}
}
