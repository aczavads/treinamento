package treinamento.dia10.conta_contabil;

import java.util.List;
import java.util.Map;

import treinamento.dia10.base.BaseService;
import treinamento.dia10.base.TransationalService;

@TransationalService
public class ContaContabilService extends BaseService<
	ContaContabil, 
	ContaContabilDTO, 
	ContaContabilRepository> {
	
	private ContaContabil findContaByIdOrNull(Long id) {
		if (id != null) {
			return  findById(id);
		}
		return null;
	}

	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
	
	public List<ContaContabil> findContasDoPlanoDeContas(Long id) {
		return repo.findContasDoPlanoDeContas(id);
	}

}













