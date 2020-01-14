package treinamento.dia6.livro;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treinamento.dia6.MeuLogger;

@Service
@Transactional
public class LivroService {
	@Autowired
	private LivroRepository repo;
	
	@Autowired
	private MeuLogger logger;
	
	public void gerarLoteDeLivros() {
		logger.log("Iniciando geração de livros...");
		for (int i = 0; i < 10; i++) {
			repo.save(new Livro("Novo livro " + System.nanoTime()));
		}
		logger.log("Livros gerados!");
	}
	
	public List<Livro> findAll() {
		return repo.findAll();
	}

}
