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

import guscam.dia7.RegistroNaoEncontrado;

@Service
@Transactional
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabil> findAll() {
		return repo.findAll();
	}
	
	public ContaContabil save(ContaContabilDTO conta) {
		ContaContabil contaSuperior = null;
		if (conta.getContaSuperiorId() != null) {
			contaSuperior = findById(conta.getContaSuperiorId());
		}
		ContaContabil novaConta = new ContaContabil(conta.getCodigo(), conta.getNome(), contaSuperior);
		return repo.save(novaConta);
	}

	public ContaContabil findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta não encontrada"));
	}

	public Long contarNumeroDeContas() {
		return repo.contarContas();
	}

	public List<ContaContabil> selecionarContasRaiz() {
		return repo.selecionarContasRaiz();
	}

	public List<Map<String, Object>> selecionarContasPelaHierarquia() {
		return repo.selecionarContasPelaHierarquia();
	}
	
	public Page<ContaContabil> recuperarTodas(Pageable pageable){
		return repo.recuperarTodas(pageable);		
	}

	public Slice<ContaContabil> recuperarTodasFatiadas(Pageable pageable){
		return repo.recuperarTodasFatiadas(pageable);		
	}

	public List<ContaContabil> recuperarTodasManualmente(int page, int size){
		return repo.recuperarTodasManualmente(page, size);		
	}

	public List<ContaContabil> recuperarContasDoPlanoDeContas(UUID idDoPlano) {
		return repo.recuperarContasDoPlanoDeContas(idDoPlano);		
	}

	public void remover(UUID id) {
		repo.deleteById(id);
	}
	
}
