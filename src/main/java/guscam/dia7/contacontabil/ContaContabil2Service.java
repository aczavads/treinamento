package guscam.dia7.contacontabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContaContabil2Service {
	@Autowired
	private ContaContabil2Repository repo;

	public List<ContaContabil2> findAll() {
		return repo.findAll();
	}
	
	public void save(ContaContabil2 conta) {
		repo.save(conta);
	}

	public ContaContabil2 findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta não encontrada"));
	}

	public Long contarNumeroDeContas() {
		return repo.contarContas();
	}

	public List<ContaContabil2> selecionarContasRaiz() {
		return repo.selecionarContasRaiz();
	}

	public List<Map<String, Object>> selecionarContasPelaHierarquia() {
		return repo.selecionarContasPelaHierarquia();
	}
	
}
