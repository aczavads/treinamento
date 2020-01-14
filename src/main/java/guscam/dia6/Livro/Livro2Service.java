package guscam.dia6.Livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Livro2Service {
	@Autowired
	private Livro2Repository repo;
	
	@Autowired
	private MeuLogger logger;	
	
	public void gerarLoteDeLivros() {
		logger.log("Começando a gerar lotes");
		for (int i = 0; i < 10; i++) {
			repo.save(new Livro2("livro numero " + i));
		}
		logger.log("Finalizando geração de lotes");
	}
	
	public List<Livro2> findAll(){
		return repo.findAll();
	}
}
