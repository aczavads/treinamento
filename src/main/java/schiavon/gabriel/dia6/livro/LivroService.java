package schiavon.gabriel.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public void gerarLoteLivros() {
		for (int i = 0; i < 10; i++) {
			livroRepository.save(new Livro("Novo livro " + System.nanoTime()));
		}
	}
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}
}
