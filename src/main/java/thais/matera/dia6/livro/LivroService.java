package thais.matera.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thais.matera.dia6.MyLogger;

@Service
@Transactional
public class LivroService {
	@Autowired
	public LivroRepository repo;
	
	@Autowired
	private MyLogger logger;
	
	public void gerarLoteDeLivros() {
		logger.log("Iniciando geração de livros...");
		for(int i = 0; i < 10; i++) {
			repo.save(new Livro("novo livro " + System.nanoTime()));
		}
		logger.log("Livros gerados!");
	}
	
	public List<Livro> findAll() {
		return repo.findAll();
	}
}
