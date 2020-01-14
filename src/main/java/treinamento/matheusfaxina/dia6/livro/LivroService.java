package treinamento.matheusfaxina.dia6.livro;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private MeuLogger meuLogger;
	
	public void gerarLoteDeLivros() {
		meuLogger.log("Iniciando geração de livros.");
		for (int i = 0; i < 10; i++) {
			livroRepository.save(new Livro("Livro: " + System.nanoTime()));
		}
		meuLogger.log("Terminando geração de livros.");
	}
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}
	
}
