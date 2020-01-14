package william.dia7.Conta_Contabilwd;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repository;

	public List<ContaContabil> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	public void save(ContaContabil contaContabil) {
		repository.save(contaContabil);
	}

	public ContaContabil findById(UUID id) {
		// TODO Auto-generated method stub
		return repository.
				findById(id).orElseThrow(() -> new ContaNãoEncontrada("Registro não encontrado!"));
	}

	public Long contarContas() {
		// TODO Auto-generated method stub
		return repository.contarContas();
	}

	public List<ContaContabil> contasRaiz() {
		// TODO Auto-generated method stub
		return repository.selecionarContasRaiz();
	}

	public List<Map<String, Object>> hierarquia() {
		// TODO Auto-generated method stub
		return repository.recuperarHierarquia();
	}

}
