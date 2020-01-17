package treinamento.dia10.plano_de_contas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia10.base.RegistroNaoEncontrado;
import treinamento.dia10.base.TransationalService;
import treinamento.dia10.conta_contabil.ContaContabil;
import treinamento.dia10.conta_contabil.ContaContabilRepository;



@TransationalService
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repo;
	
	@Autowired
	private EntityManager em;

	@Autowired
	private ContaContabilRepository repoContaContabil;

	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas novo = new PlanoDeContas(
				dto.getId(), 
				dto.getVersion(), 
				dto.getDescricao(), 
				dto.getInicioVigencia(),
				dto.getFimVigencia());
		return repo.save(novo);
	}

	public void update(PlanoDeContasDTO dto) {
		PlanoDeContas recuperado = repo
			.findById(dto.getId())
			.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		recuperado.setDescricao(dto.getDescricao());
		recuperado.setInicioVigencia(dto.getInicioVigencia());
		recuperado.setFimVigencia(dto.getFimVigencia());
	}

	public List<PlanoDeContas> findAll() {
		return repo.findAll();
	}


	public List<ContaContabil> getContas(UUID id) {
		return new ArrayList<ContaContabil>(repo.findById(id).get().getContasContabeis());
	}

	public void deleteById(UUID id) {
		repo.deleteById(id);
	}

	public void adicionarContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContas plano = repo
				.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		List<ContaContabil> contasParaAdicionar = repoContaContabil
				.findAllById(idsDasContasParaAdicionar);
		if (contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		contasParaAdicionar.forEach(cc -> plano.adicionar(cc));
	}
	public void deleteContasDoPlano(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaRemover) {
		PlanoDeContas plano = repo
				.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		List<ContaContabil> contasParaAdicionar = repoContaContabil
				.findAllById(idsDasContasParaRemover);
		if (contasParaAdicionar.size() != idsDasContasParaRemover.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		contasParaAdicionar.forEach(cc -> plano.remover(cc));	
	}
}




