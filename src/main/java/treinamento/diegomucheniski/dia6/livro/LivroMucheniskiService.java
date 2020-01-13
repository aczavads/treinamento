package treinamento.diegomucheniski.dia6.livro;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional // Cada m�todo dessa classe inicializa e encerra uma se��o.
public class LivroMucheniskiService {
	
	@Autowired
	private LivroMucheniskiRepository livroRepository;
	
	@Autowired
	private MeuLogger meuLogger;
	
	@Autowired
	private DataSource dataSource; // Caso necess�rio posso usar o DataSource do JDBC pois o JPA tem JDBC.
	
	public void gerarLoteTeste() {
		meuLogger.log("Iniciando gera��o de livros...");
		for (int i = 0; i < 10; i++) {
			livroRepository.save(new LivroMucheniski("Novo Livro: " + System.nanoTime()));
		}
		meuLogger.log("Livros gerados!");
	}
	
	public List<LivroMucheniski> findAll() {
		return livroRepository.findAll();
	}

}
