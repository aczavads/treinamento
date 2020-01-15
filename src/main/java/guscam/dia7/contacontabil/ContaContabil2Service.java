package guscam.dia7.contacontabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContaContabil2Service {
	@Autowired
	private ContaContabil2Repository repo;

	public List<ContaContabil2> findAll() {
		return repo.findAll();
	}
	
	public ContaContabil2 save(ContaContabil2DTO conta) {
		ContaContabil2 contaSuperior = null;
		if (conta.getContaSuperiorId() != null) {
			contaSuperior = findById(conta.getContaSuperiorId());
		}
		ContaContabil2 novaConta = new ContaContabil2(conta.getCodigo(), conta.getNome(), contaSuperior);
		return repo.save(novaConta);
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
	
	public Page<ContaContabil2> recuperarTodas(Pageable pageable){
		return repo.recuperarTodas(pageable);		
	}

	public Slice<ContaContabil2> recuperarTodasFatiadas(Pageable pageable){
		return repo.recuperarTodasFatiadas(pageable);		
	}

	public List<ContaContabil2> recuperarTodasManualmente(int page, int size){
		return repo.recuperarTodasManualmente(page, size);		
	}
	
}
