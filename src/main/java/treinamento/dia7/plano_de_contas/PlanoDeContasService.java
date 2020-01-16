package treinamento.dia7.plano_de_contas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia7.conta_contabil.TransationalService;

@TransationalService
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repo;
	
	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas novo = new PlanoDeContas(
				dto.getId(), 
				dto.getDescricao(),
				dto.getInicioVigencia(), 
				dto.getFimVigencia());
		return repo.save(novo);
	}
	public List<PlanoDeContas> findAll() {
		return repo.findAll();
	}
}




