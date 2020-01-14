package thais.matera.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@TransactionalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;
	
	public List<ContaContabil> findAll() {
		return repo.findAll();
	}

	public ContaContabil save(ContaContabilDTO nova) {
		ContaContabil contaSuperior = null;
		
		if(nova.getContaSuperiorId() != null) {
			contaSuperior = findById(nova.getContaSuperiorId()).orElseThrow(() -> new RegistroNaoEncontrado("Conta superior não encontrada"));
		}
		
		ContaContabil novaContaC = null;
		if(nova.getId() != null) {
			novaContaC = new ContaContabil(nova.getId(), nova.getCodigo(), nova.getNome(), contaSuperior);
		}else {
			novaContaC = new ContaContabil(nova.getCodigo(), nova.getNome(), contaSuperior);
		}
		
		return repo.save(novaContaC);
	}

	public Optional<ContaContabil> findById(UUID id) {
		return repo.findById(id);
	}
	
	public Long contarContas() {
		return repo.contarContas();
	}
	
	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
	
	public List<ContaContabilDTO> selecionarContasRaiz() {
		return repo.selecionarContasRaiz();
	}

}
