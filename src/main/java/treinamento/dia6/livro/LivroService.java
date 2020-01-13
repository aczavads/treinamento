package treinamento.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class LivroService {
	@Autowired
	public LivroRepository repo;
	
	public void gerarLoteDeLivros() {
		for (int i = 0; i < 10; i++) {
			repo.save(new Livro("Novo livro " + System.nanoTime()));
		}
	}
	
	public List<Livro> findAll() {
		return repo.findAll();
	}

}
