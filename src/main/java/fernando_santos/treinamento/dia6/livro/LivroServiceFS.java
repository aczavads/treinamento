package fernando_santos.treinamento.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fernando_santos.treinamento.dia6.MeuLoggerFS;

@Service
@Transactional
public class LivroServiceFS {
	
	@Autowired
	private LivroRepositoryFS repository;
	
	@Autowired
	private MeuLoggerFS meuLogger;
	
	public void gerarLoteDeLivros() {
		for (int i = 0; i < 10; i++) {
			repository.save(new LivroFS("Novo Livro " + (i + 1) + " " + System.nanoTime()));
		}
		meuLogger.log("Livros foram gerados.");
	}
	
	public List<LivroFS> findAll() {
		meuLogger.log("Todos livros foram buscados.");
		return repository.findAll();
	}

}
