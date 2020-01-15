package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlanoDeContasService {

	@Autowired
	private PlanoDeContasRepository repository;

	public PlanoDeContasFS2 save(PlanoDeContasFS2 planoDeContas) {
		return repository.save(planoDeContas);
	}

	public List<PlanoDeContasFS2> getAll() {
		return repository.findAll();
	}

}
