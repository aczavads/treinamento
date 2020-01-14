package treinamento.dia7.conta_contabil.fernando.santos;

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
	ContaContabilRepository repository;

	public List<ContaContabilFS> findAll() {
		return repository.findAll();
	}

	public void save(ContaContabilFS contaContabil) {
		repository.save(contaContabil);
	}

	public ContaContabilFS getById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contabil " + id));
	}

	public Long getQuantidadeDeContas() {
		return repository.contarContas();
	}

	public List<ContaContabilFS> getContasSemPai() {
		return repository.selecionarContaRaiz();
	}

	public List<Map<String, Object>> getContasHierarquicamente() {
		return repository.recuperarHierarquia();
	}

}
