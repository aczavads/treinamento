package thais.matera.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import prefixo.HierarquiaInvalida;

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
			contaSuperior = findById(nova.getContaSuperiorId());
		}
		
		if(contaSuperior != null) {
			if(!ehFilhoValido(contaSuperior.getCodigo(), nova.getCodigo())) {
				throw new HierarquiaInvalida("Código da filha não forma hierarquia com o código do superior");
			}
		}
		
		ContaContabil novaContaContabil = null;
		if(nova.getId() != null) {
			if(!repo.findById(nova.getId()).isPresent()) {
				novaContaContabil = new ContaContabil(nova.getId(), nova.getCodigo(), nova.getNome(), contaSuperior);				
			}else {
				throw new RegistroExistente("id repetido");
			}
		}else {
			novaContaContabil = new ContaContabil(nova.getCodigo(), nova.getNome(), contaSuperior);
		}
		
		return repo.save(novaContaContabil);
	}

	private boolean ehFilhoValido(String superior, String filha) {
		int tamanhoSuperior = superior.trim().length();
		String prefixo = filha.trim().substring(0, tamanhoSuperior);
		
		if(!prefixo.equals(superior))
			return false;
		
		if(!filha.substring(tamanhoSuperior, tamanhoSuperior+1).equals("."))
			return false;
		
//		if(Integer.parseInt(filha.substring(tamanhoSuperior+1, filha.length()))) {
//		}
		
		return true;
	}

	public ContaContabil findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contabil " + id));
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
