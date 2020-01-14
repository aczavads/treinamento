package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TransationalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabilFS2> findAll() {
		return repo.findAll();
	}
	
	public ContaContabilFS2 save(ContaContabilDTO nova) {
		ContaContabilFS2 contaSuperior = null;
		if (nova.getContaSuperiorId() != null) {
			contaSuperior = findById(nova.getContaSuperiorId());
		}
		ContaContabilFS2 novaContaContabil = null;
		
		UUID contaSuperiorId = nova.getContaSuperiorId();
		if(contaSuperiorId != null) {
			Optional<ContaContabilFS2> contaSuperiorEncontrada = repo.findById(contaSuperiorId);
			
			if(contaSuperiorEncontrada.isPresent()) {
				String codigoSuperior = contaSuperiorEncontrada.get().getCodigo();
				if(!codigoSuperior.contains(".")) {
					codigoSuperior = codigoSuperior.concat(".");
				}
				String codigoFilho = nova.getCodigo();
				if(!codigoSuperior.startsWith(codigoFilho)) {
					throw new CodigoDoContaContabilidadeInvalido();
				}
			}
			
		}
		
		
		if (nova.getId() == null) {
			novaContaContabil = new ContaContabilFS2(nova.getCodigo(), nova.getNome(), contaSuperior);			
		} else {
			novaContaContabil = new ContaContabilFS2(nova.getId(), nova.getCodigo(), nova.getNome(), contaSuperior);			
		}
		return repo.save(novaContaContabil);
	}

	public ContaContabilFS2 findById(UUID id) {
		return repo
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado("Conta contábil: " + id));
	}
	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}
}
