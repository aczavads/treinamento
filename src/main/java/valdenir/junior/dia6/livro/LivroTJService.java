package valdenir.junior.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import valdenir.junior.dia6.MeuLogger;

@Service
@Transactional
public class LivroTJService {

	@Autowired
	private MeuLogger logger;
	@Autowired
	private LivroTJRepository repository;

	public void gerarLoteDeLivros() {
		repository.safe(new LivroTJ("Titulo 1"));
	}

	public List<LivroTJ> findAll() {
		logger.log("lista");
		return repository.findAll();
	}
}
