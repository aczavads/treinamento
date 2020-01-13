package treinamento.guilhermeperes.dia6.livro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LivroService {
	@Autowired
	private LivroRepository repo;
	
	public void gerarLote(List<Livro> lote) {
		lote.stream().forEach(livro -> repo.save(livro));
	}
	
	public List<Livro> findAll() {
		return repo.findAll();
	}
}
