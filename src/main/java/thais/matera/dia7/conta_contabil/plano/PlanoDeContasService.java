package thais.matera.dia7.conta_contabil.plano;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import thais.matera.dia7.conta_contabil.TransactionalService;

@TransactionalService
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repo;
	
	public PlanoDeContas save(PlanoDeContasDTO entity) {
		PlanoDeContas novo = new PlanoDeContas(
				entity.getId(),
				entity.getDescricao(),
				entity.getInicioVigencia(),
				entity.getFimVigencia()
		);
		return repo.save(novo);
	}
	
	public List<PlanoDeContas> findAll() {
		return repo.findAll();
	}
}
