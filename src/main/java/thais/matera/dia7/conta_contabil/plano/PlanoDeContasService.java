package thais.matera.dia7.conta_contabil.plano;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import thais.matera.dia7.conta_contabil.ContaContabil;
import thais.matera.dia7.conta_contabil.ContaContabilRepository;
import thais.matera.dia7.conta_contabil.RegistroNaoEncontrado;
import thais.matera.dia7.conta_contabil.TransactionalService;

@TransactionalService
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repo;
	
	@Autowired
	private ContaContabilRepository repoContaContabil;
	
	public PlanoDeContas save(PlanoDeContasDTO entity) {
		PlanoDeContas novo = new PlanoDeContas(
				entity.getId(),
				entity.getDescricao(),
				entity.getInicioVigencia(),
				entity.getFimVigencia()
		);
		return repo.save(novo);
	}
	
	public List<PlanoDeContas> findAll() {
		return repo.findAll();
	}

	public List<ContaContabil> findContasDoPlanoDeContas(UUID id) {
		return repoContaContabil.findContasDoPlanoDeContas(id);
	}

	public void adicionarContas(UUID id, List<UUID> contasID) {
		PlanoDeContas plano = repo
				.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
		for(UUID uuid : contasID) {
			ContaContabil conta = repoContaContabil.findById(uuid).orElseThrow(() -> new RegistroNaoEncontrado(""));
			plano.adicionar(conta);
		}
	}

	public void delete(UUID id) {
		PlanoDeContas plano = repo
				.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
		repo.delete(plano);
	}

	public void removerContas(UUID id, List<UUID> contasID) {
		PlanoDeContas plano = repo
				.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
		for(UUID uuid : contasID) {
			ContaContabil conta = repoContaContabil.findById(uuid).orElseThrow(() -> new RegistroNaoEncontrado(""));
			plano.remover(conta);
		}
	}
}
