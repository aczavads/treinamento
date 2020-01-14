package william.silva.dia6.Livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LivroServiceWd {
	@Autowired
	public LivroRepositoryWd repo;
	
	public void gerarLoteDeLivros() {
		for (int i = 0; i < 10; i++) {
			repo.save(new LivroWd("Novo Livro "+ System.nanoTime()));
		}
	}

	public List<LivroWd>findAll() {
		return repo.findAll();
		
	}
	

}
