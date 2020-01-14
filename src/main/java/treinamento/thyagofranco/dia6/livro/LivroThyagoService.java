package treinamento.thyagofranco.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
// @Service = @Component
@Service
@Transactional
public class LivroThyagoService {
	
	//public LivroThyagoRepository repo = new LivroThyagoRepository(); Instancia n�o gerenciada pelo Spring
	
	@Autowired //depend�ncia
	private LivroThyagoRepository repo;
	
//	@Autowired
//	private DataSource dataSource; podemos injetar um dataSource para efetuar preperment statment e utilizar c�digo sql
	
	@Autowired
	private LoggerThyago logger;
	
	public void gerarLoteDeLivros() {
		logger.log("iniciando gera��o de livros....");
		for (int i = 0; i < 10; i++) {
			repo.save(new LivroThyago("Novo livro" + System.nanoTime()));
			
		}
		logger.log("Livros gerados!");
	}
	
	public List<LivroThyago> findAll(){
		return repo.findAll(); 
	}

}
